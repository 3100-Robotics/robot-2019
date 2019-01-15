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

    private static TalonSRX motor = RobotMap.leftDriveMotor1;
    /**
     * Which PID slot to pull gains from. Starting 2018, you can choose from
     * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
     * configuration.
     */
    private static int kSlotIdx = 0;
    /**
     * Talon SRX/ Victor SPX will supports multiple (cascaded) PID loops. For
     * now we just want the primary one.
     */
    private static int kPIDLoopIdx = 0;
    /**
     * Set to zero to skip waiting for confirmation, set to nonzero to wait and
     * report to DS if action fails.
     */
    private static int kTimeoutMs = 30;
    /* Choose so that Talon does not report sensor out of phase */
    private static boolean kSensorPhase = false;

    /**
     * Gains used in Positon Closed Loop, to be adjusted accordingly
     * Gains(kp, ki, kd, kf, izone, peak output);
     */
    private static final Gains kGains = new Gains(1, 0.0, 0, 0.0, 0, 1.0);;
    private static double pos;

    public Arm() {
        super("Arm");

        /* Config the sensor used for Primary PID and sensor direction */
        motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
                kPIDLoopIdx,
                kTimeoutMs);

        /* Ensure sensor is positive when output is positive */
        motor.setSensorPhase(kSensorPhase);

        /* Config the peak and nominal outputs, 12V means full */
        motor.configNominalOutputForward(0, kTimeoutMs);
        motor.configNominalOutputReverse(0, kTimeoutMs);
        motor.configPeakOutputForward(1, kTimeoutMs);
        motor.configPeakOutputReverse(-1, kTimeoutMs);

        /**
         * Config the allowable closed-loop error, Closed-Loop output will be
         * neutral within this range. See Table in Section 17.2.1 for native
         * units per rotation.
         */
        motor.configAllowableClosedloopError(0, kPIDLoopIdx, kTimeoutMs);

        /* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
        motor.config_kF(kPIDLoopIdx, kGains.kF, kTimeoutMs);
        motor.config_kP(kPIDLoopIdx, kGains.kP, kTimeoutMs);
        motor.config_kI(kPIDLoopIdx, kGains.kI, kTimeoutMs);
        motor.config_kD(kPIDLoopIdx, kGains.kD, kTimeoutMs);
        motor.setSelectedSensorPosition(0);

    }


    public void rotate(double speed) {
            motor.set(ControlMode.PercentOutput,speed);

    }

    public void movePosition(double position) {
        SmartDashboard.putNumber("a",7);
        this.pos = position;
        motor.set(ControlMode.Position,position);
    }





    public void initDefaultCommand() {
        setDefaultCommand(new ArmMotion());
    }

    public void initSD() {
        if(motor.getControlMode() == ControlMode.Position) {
            SmartDashboard.putNumber("target",pos);
        }
        SmartDashboard.putBoolean("Arm Break",RobotMap.armBrakeEngage.get());
        SmartDashboard.putNumber("MotorSpeed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Position",motor.getSensorCollection().getQuadraturePosition());
    }

    public void updateSD() {
        if(motor.getControlMode() == ControlMode.Position) {
            SmartDashboard.putNumber("target",pos);
        }
        SmartDashboard.putBoolean("Arm Break",RobotMap.armBrakeEngage.get());
        SmartDashboard.putNumber("MotorSpeed",motor.getOutputCurrent());
        SmartDashboard.putNumber("Position",motor.getSensorCollection().getQuadraturePosition());
    }
}
