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
        setDefaultCommand(new ArmMotion());
    }

    public void manualRotation(double speed) {
        speed = deadband(speed);
        double scaleSpeed = speed < 0 ? -1 : 1;
        speed *= speed * scaleSpeed;
        if(speed != 0) {
            motor.set(ControlMode.PercentOutput, speed);
            System.out.println("Moving");
            ran = false;

        } else if(speed == 0 && !ran) {
            motor.set(ControlMode.PercentOutput, 0);
            System.out.println("stopped");
            ran = true;
        }
    }

    public void movePosition(double position) {
        pos = position;
        motor.set(ControlMode.Position,position);

    }

    private double deadband(double input) {
        if(Math.abs(input) < Variables.joystickError) {
            return 0;
        } else {
            return input;
        }
    }

    public int getCurrentPosition() {
        return motor.getSelectedSensorPosition();
    }

    public void stop() {
        motor.set(ControlMode.PercentOutput,0);
        ran = true;
    }





    public void initSD() {

    }

    public void updateSD() {
        SmartDashboard.putNumber("Arm target",pos);
        SmartDashboard.putNumber("Arm Speed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Arm Position",motor.getSensorCollection().getAnalogInRaw());
        SmartDashboard.putNumber("Arm Position2",motor.getSensorCollection().getAnalogIn());
        SmartDashboard.putNumber("Arm Position3",this.getCurrentPosition());

    }
}
