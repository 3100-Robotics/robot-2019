package frc.team3100.robot.Wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Pretty much an identical copy of the arm subsystem. Defines all aspects of the wrist and
enables for PID Position control.
 */

public class Wrist extends Subsystem implements Dashboard.DashboardUpdatable {

    private static TalonSRX motor = RobotMap.wristMotor;
    private boolean ran = false;
    private double pos;

    public Wrist() {
        super("Wrist");

        /* Config the sensor used for Primary PID and sensor direction */
        motor.configSelectedFeedbackSensor(FeedbackDevice.Analog,0,30);

        /* Config the peak and nominal outputs, 12V means full */
        motor.configNominalOutputForward(0);
        motor.configNominalOutputReverse(0);
        motor.configPeakOutputForward(1);
        motor.configPeakOutputReverse(-1);

        /* Config Position Closed Loop gains in slot0, typically kF stays zero. */
        motor.config_kF(0,Variables.wristGains.kF);
        motor.config_kP(0,Variables.wristGains.kP);
        motor.config_kI(0,Variables.wristGains.kI);
        motor.config_kD(0,Variables.wristGains.kD);

        int absolutePosition = motor.getSensorCollection().getAnalogInRaw();
        motor.setSelectedSensorPosition(absolutePosition);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new WristMotion());
    }

    public void manualRotation(double speed) {
        speed = deadband(speed);

        if(motor.getSensorCollection().getAnalogInRaw() < 220) {
            if(speed > 0) {
                speed = .21;
            }
        } else if(motor.getSensorCollection().getAnalogInRaw() > 720) {
            if(speed < 0) {
                speed = -.21;
            }
        }
        double scaleSpeed = speed < 0 ? -1 : 1;
        speed *= speed * scaleSpeed;


        if(speed != 0) {
            motor.set(ControlMode.PercentOutput, speed);
            ran = false;

        } else if(speed == 0 && !ran) {
            motor.set(ControlMode.PercentOutput, 0);
            ran = true;
        }
    }

    public void movePosition(double position) {

        if(position < 215) {
            position = 215;
            System.out.println("Lower Bound Tripped");
        } else if(position > 720) {
            position = 720;
            System.out.println("Upper Bound Tripped");
        }
        pos = position;
        motor.set(ControlMode.Position, position);
    }

    private double deadband(double input) {
        if(Math.abs(input) < Variables.joystickError) {
            return 0;
        } else {
            return input;
        }
    }


    public double getCurrentPosition() {
        return motor.getSensorCollection().getAnalogIn();
    }

    public void stop() {
        motor.set(ControlMode.PercentOutput,0);
    }






    public void initSD() {

    }

    public void updateSD() {
        SmartDashboard.putNumber("Wrist target",pos);
        SmartDashboard.putNumber("Wrist Speed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Wrist Position",motor.getSensorCollection().getAnalogInRaw());
        SmartDashboard.putNumber("Wrist Position2",motor.getSensorCollection().getAnalogIn());
        SmartDashboard.putNumber("Wrist Position3",this.getCurrentPosition());

    }
}

