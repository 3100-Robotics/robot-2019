package frc.team3100.robot.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Subsystem that defines the motion for the arm component of the game piece manipulator.
Defines the breaking action, PID controlled motion, and interfaces with the absolute encoder.
 */


public class Arm extends Subsystem implements Dashboard.DashboardUpdatable {

    private static TalonSRX motor = RobotMap.armMotor1;
    private double pos;
    private boolean ran = false;

    public Arm() {
        super("Arm");

        // Configure all Arm TalonSRX settings for auto control
        motor.configFactoryDefault();
        /* Config the sensor used for Primary PID and sensor direction */
        motor.configSelectedFeedbackSensor(FeedbackDevice.Analog,0,0);
        motor.setSensorPhase(false);


        /* Config Position Closed Loop gains in slot0, typically kF stays zero. */
        motor.config_kF(0,Variables.armGains.kF);
        motor.config_kP(0,Variables.armGains.kP);
        motor.config_kI(0,Variables.armGains.kI);
        motor.config_kD(0,Variables.armGains.kD);
        int absolutePosition = motor.getSensorCollection().getAnalogInRaw();
        motor.setSelectedSensorPosition(absolutePosition);
    }

    public void initDefaultCommand() {
        // Set up manual motion command
        setDefaultCommand(new ArmMotion());
    }

    public void manualRotation(double speed) {
        // Using the input from manual motion command to move the arm
        speed = deadband(speed);

        // Soft limits for arm motion

        if(motor.getSensorCollection().getAnalogInRaw() < 240) {
            if(speed < 0) {
                speed = .29;
            }
        } else if(motor.getSensorCollection().getAnalogInRaw() > 850) {
            if(speed > 0) {
                speed = -.29;
            }
        }

        // Scaling the arm speed for more intuitive control
        double scaleSpeed = speed < 0 ? -1 : 1;
        speed *= speed * scaleSpeed;


        if(speed != 0) {
            motor.set(ControlMode.PercentOutput, speed);
            ran = false;

        } else if(speed == 0 && !ran) {
            //Ensuring motor isn't still running within the controller deadband
            motor.set(ControlMode.PercentOutput, 0);
            ran = true;
        }
    }

    public void movePosition(double position) {
        // Using the position from the AutoClawMotion command and starting the built-in PID

        // Soft-limit on motion
        int absolutePosition = motor.getSensorCollection().getAnalogInRaw();
        motor.setSelectedSensorPosition(absolutePosition);
        if(position < 220) {
            position = 220;
            System.out.println("Lower Bound Tripped");
        } else if(position > 980) {
            position = 980;
            System.out.println("Upper Bound Tripped");
        }

        pos = position;
        // Starting position control
        motor.set(ControlMode.Position,position);

    }

    private double deadband(double input) {
        // Defining the controller deadband
        if(Math.abs(input) <= Variables.joystickError) {
            return 0;
        } else {
            return input;
        }
    }

    public int getCurrentPosition() {
        // Find the current position of the sensor
        return motor.getSelectedSensorPosition();
    }

    public void stop() {
        // Halt all arm motion with one simple command! Buy one today!
        motor.set(ControlMode.PercentOutput,0);
        ran = true;
    }





    public void initSD() {

    }

    public void updateSD() {
        // All smartdashboard debug values
        SmartDashboard.putNumber("Arm target",pos);
        SmartDashboard.putNumber("Arm Speed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Arm Position",motor.getSensorCollection().getAnalogInRaw());
        SmartDashboard.putNumber("Arm Position2",motor.getSensorCollection().getAnalogIn());
        SmartDashboard.putNumber("Arm Position3",this.getCurrentPosition());

    }
}
