package frc.team3100.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import frc.team3100.robot.Mapping.RobotMap;

public class TalonConfig {

    public void configure() {


        RobotMap.leftDriveMotor1.configFactoryDefault();
        RobotMap.rightDriveMotor1.configFactoryDefault();

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
        System.out.println("yay");

        RobotMap.leftDriveMotor1.setNeutralMode(NeutralMode.Brake);
        RobotMap.leftDriveMotor2.setNeutralMode(NeutralMode.Brake);
        RobotMap.leftDriveMotor3.setNeutralMode(NeutralMode.Brake);
        RobotMap.rightDriveMotor1.setNeutralMode(NeutralMode.Brake);
        RobotMap.rightDriveMotor2.setNeutralMode(NeutralMode.Brake);
        RobotMap.rightDriveMotor3.setNeutralMode(NeutralMode.Brake);





        // Configure the drivetrain's left side Feedback Sensor as a Quadrature Encoder
        RobotMap.leftDriveMotor1.configSelectedFeedbackSensor(	FeedbackDevice.QuadEncoder,			// Local Feedback Source
                0,				// PID Slot for Source [0, 1]
                30);              // Configuration Timeout


        // Configure the left Talon's Selected Sensor to be a remote sensor for the right Talon
        RobotMap.rightDriveMotor1.configRemoteFeedbackFilter(RobotMap.leftDriveMotor1.getDeviceID(),					// Device ID of Source
                RemoteSensorSource.TalonSRX_SelectedSensor,	// Remote Feedback Source
                0);						// Configuration Timeout


        // Setup difference signal to be used for turn when performing Drive Straight with encoders
        RobotMap.rightDriveMotor1.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor0);	// Feedback Device of Remote Talon
        RobotMap.rightDriveMotor1.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.QuadEncoder);		// Quadrature Encoder of current Talon

        // Difference term calculated by right Talon configured to be selected sensor of turn PID
        RobotMap.rightDriveMotor1.configSelectedFeedbackSensor(	FeedbackDevice.SensorDifference,
                0,0);


        // Configure neutral deadband
        RobotMap.rightDriveMotor1.configNeutralDeadband(Variables.kNeutralDeadband);
        RobotMap.leftDriveMotor1.configNeutralDeadband(Variables.kNeutralDeadband);

        // FPID Gains for turn servo
        RobotMap.rightDriveMotor1.config_kP(0, Variables.kGains_Turning.kP);
        RobotMap.rightDriveMotor1.config_kI(0, Variables.kGains_Turning.kI);
        RobotMap.rightDriveMotor1.config_kD(0, Variables.kGains_Turning.kD);
        RobotMap.rightDriveMotor1.config_kF(0, Variables.kGains_Turning.kF);

        int closedLoopTimeMs = 1;
        RobotMap.rightDriveMotor1.configClosedLoopPeriod(0, closedLoopTimeMs);
        RobotMap.rightDriveMotor1.configClosedLoopPeriod(1, closedLoopTimeMs);

    }
}
