package frc.team3100.robot.Wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Gains;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Pretty much an identical copy of the arm subsystem. Defines all aspects of the wrist and
enables for PID Position control.
 */

public class Wrist extends Subsystem implements Dashboard.DashboardUpdatable {

    private static TalonSRX motor = RobotMap.wristMotor;

    private static final Gains kGains = new Gains(.225, 0.0, 0, 0, 0, 1.0);
    private double pos;

    public Wrist() {
        super("Wrist");

        /* Config the sensor used for Primary PID and sensor direction */
        motor.configSelectedFeedbackSensor(FeedbackDevice.Analog,0,0);
        motor.setSensorPhase(false);

        /* Config the peak and nominal outputs, 12V means full */
        motor.configNominalOutputForward(0);
        motor.configNominalOutputReverse(0);
        motor.configPeakOutputForward(1);
        motor.configPeakOutputReverse(-1);

        /* Config Position Closed Loop gains in slot0, typically kF stays zero. */
        motor.config_kF(0,kGains.kF);
        motor.config_kP(0,kGains.kP);
        motor.config_kI(0,kGains.kI);
        motor.config_kD(0,kGains.kD);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new WristMotion());
    }

    public void manualRotation(double speed) {
        speed = Math.abs(speed) < Variables.joystickError ? 0:speed;

        if(speed != 0) {
            motor.set(ControlMode.PercentOutput, speed);
        }
    }

    public void movePosition(double position) {
        if(position != pos) {
            pos = position;
            motor.set(ControlMode.Position, position);
        } else {
            System.out.println("Repeat Wrist Motion Command");
        }
    }



    public double getCurrentPosition() {
        return motor.getSelectedSensorPosition();
    }

    public void stop() {
        motor.set(ControlMode.PercentOutput,0);
    }






    public void initSD() {

    }

    public void updateSD() {
        SmartDashboard.putNumber("Wrist target",pos);
        SmartDashboard.putNumber("Wrist Speed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Wrist Position",this.getCurrentPosition());
    }
}

