package frc.team3100.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import frc.team3100.robot.Mapping.RobotMap;

public class TalonConfig {

    public void configure() {

        // Set Up Followers
        RobotMap.leftDriveMotor2.follow(RobotMap.leftDriveMotor1);
        RobotMap.leftDriveMotor3.follow(RobotMap.leftDriveMotor1);
        RobotMap.rightDriveMotor2.follow(RobotMap.rightDriveMotor1);
        RobotMap.rightDriveMotor3.follow(RobotMap.rightDriveMotor1);
        RobotMap.armMotor2.follow(RobotMap.armMotor1);

        // Set Inversions for cooperating motors
        RobotMap.rightDriveMotor1.setInverted(true);
        RobotMap.rightDriveMotor2.setInverted(false);
        RobotMap.rightDriveMotor3.setInverted(false);
        RobotMap.leftDriveMotor1.setInverted(false);
        RobotMap.leftDriveMotor2.setInverted(true);
        RobotMap.leftDriveMotor3.setInverted(true);



        /*
        // Configure the drivetrain's left side Feedback Sensor as a Quadrature Encoder
        RobotMap.leftDriveMotor1.configSelectedFeedbackSensor(	FeedbackDevice.QuadEncoder,			// Local Feedback Source
                Variables.PID_PRIMARY,				// PID Slot for Source [0, 1]
                Variables.kTimeoutMs);              // Configuration Timeout


        // Configure the left Talon's Selected Sensor to be a remote sensor for the right Talon
        RobotMap.rightDriveMotor1.configRemoteFeedbackFilter(RobotMap.leftDriveMotor1.getDeviceID(),					// Device ID of Source
                RemoteSensorSource.TalonSRX_SelectedSensor,	// Remote Feedback Source
                Variables.REMOTE_0,							// Source number [0, 1]
                Variables.kTimeoutMs);						// Configuration Timeout


        // Setup difference signal to be used for turn when performing Drive Straight with encoders
        RobotMap.rightDriveMotor1.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor0, Variables.kTimeoutMs);	// Feedback Device of Remote Talon
        RobotMap.rightDriveMotor1.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.QuadEncoder, Variables.kTimeoutMs);		// Quadrature Encoder of current Talon

        // Difference term calculated by right Talon configured to be selected sensor of turn PID
        RobotMap.rightDriveMotor1.configSelectedFeedbackSensor(	FeedbackDevice.SensorDifference,
                Variables.PID_TURN,
                Variables.kTimeoutMs);

        // Scale the Feedback Sensor using a coefficient

        // Configure neutral deadband
        RobotMap.rightDriveMotor1.configNeutralDeadband(Variables.kNeutralDeadband, Variables.kTimeoutMs);
        RobotMap.leftDriveMotor1.configNeutralDeadband(Variables.kNeutralDeadband, Variables.kTimeoutMs);

        // FPID Gains for turn servo
        RobotMap.rightDriveMotor1.config_kP(Variables.kSlot_Turning, Variables.kGains_Turning.kP, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.config_kI(Variables.kSlot_Turning, Variables.kGains_Turning.kI, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.config_kD(Variables.kSlot_Turning, Variables.kGains_Turning.kD, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.config_kF(Variables.kSlot_Turning, Variables.kGains_Turning.kF, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.config_IntegralZone(Variables.kSlot_Turning, Variables.kGains_Turning.kIzone, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.configClosedLoopPeakOutput(Variables.kSlot_Turning, Variables.kGains_Turning.kPeakOutput, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.configAllowableClosedloopError(Variables.kSlot_Turning, 0, Variables.kTimeoutMs);


        int closedLoopTimeMs = 1;
        RobotMap.rightDriveMotor1.configClosedLoopPeriod(0, closedLoopTimeMs, Variables.kTimeoutMs);
        RobotMap.rightDriveMotor1.configClosedLoopPeriod(1, closedLoopTimeMs, Variables.kTimeoutMs);
        */
    }
}
