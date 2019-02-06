package frc.team3100.robot.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Gains;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

import static com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;

/*
Subsystem that defines the motion for the arm component of the game piece manipulator.
Defines the breaking action, PID controlled motion, and interfaces with the absolute encoder.
 */


public class Arm extends Subsystem implements Dashboard.DashboardUpdatable {

    private static TalonSRX motor = RobotMap.armMotor1;

    private static final Gains kGains = new Gains(.225, 0.0, 0, 0, 0, 1.0);
    private double pos;

    public Arm() {
        super("Arm");

        /* Config the sensor used for Primary PID and sensor direction */
        motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
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
        motor.setSelectedSensorPosition(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArmMotion());
    }

    public void manualRotation(double speed) {
        if(speed != 0) {
            motor.set(ControlMode.PercentOutput, speed);
        }
    }

    public void movePosition(double position) {
        pos = position;
        motor.set(ControlMode.Position,position);
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
        SmartDashboard.putNumber("Arm target",pos);
        SmartDashboard.putNumber("Arm Speed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Arm Position",this.getCurrentPosition());
    }
}
