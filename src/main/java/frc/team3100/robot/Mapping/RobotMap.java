package frc.team3100.robot.Mapping;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveController = 1;

    //     P W M
    private static int clawMotorChannel = 0;
    private static int shelfMotor1Channel = 1;
    private static int shelfMotor2Channel = 2;
    private static int lifterMotor1Channel = 3;
    private static int lifterMotor2Channel = 4;


    //     C A N
    private static int driveRight1Channel = 1;
    private static int driveRight2Channel = 2;
    private static int driveRight3Channel = 3;
    private static int driveLeft1Channel = 4;
    private static int driveLeft2Channel = 5;
    private static int driveLeft3Channel = 6;
    private static int armMotor1Channel = 7;
    private static int armMotor2Channel = 8;
    private static int wristMotorChannel = 9;


    //     P C M
    private static int driveShiftLowChannel = 0;
    private static int driveShiftHighChannel = 1;
    private static int armBrakeEngageChannel = 2;
    private static int armBrakeReleaseChannel = 3;
    private static int wristBrakeEngageChannel = 4;
    private static int wristBrakeReleaseChannel = 5;


    //     D I O
    private static int wristEncoderChannel = 0;
    private static int armEncoderChannel = 1;
    private static int driveLeftEncoderChannelA = 2;
    private static int driveLeftEncoderChannelB = 3;
    private static int driveRightEncoderChannelA = 4;
    private static int driveRightEncoderChannelB = 5;
    private static int lifterEncoderChannelA = 6;
    private static int lifterEncoderChannelB = 7;
    private static int shelfEncoderChannelA = 8;
    private static int shelfEncoderChannelB = 9;



    //     X B O X
    public static final int rightXAxisChannel = 4;
    public static final int rightYAxisChannel = 5;
    public static final int leftXAxisChannel = 0;
    public static final int leftYAxisChannel = 1;

    public static final int aButtonChannel = 1;
    public static final int bButtonChannel = 2;
    public static final int xButtonChannel = 3;
    public static final int yButtonChannel = 4;

    public static final int rightBumperChannel = 6;
    public static final int leftBumperChannel = 5;

    public static final int rightTriggerChannel = 3;
    public static final int leftTriggerChannel = 2;




    //    Initialize XBox Controllers
    public static XBoxStates driveControls = new XBoxStates(driveController);

    //    Initialize speed controllers
    public static TalonSRX leftDriveMotor1 = new TalonSRX(driveLeft1Channel);
    public static TalonSRX leftDriveMotor2 = new TalonSRX(driveLeft2Channel);
    public static TalonSRX leftDriveMotor3 = new TalonSRX(driveLeft3Channel);
    public static TalonSRX rightDriveMotor1 = new TalonSRX(driveRight1Channel);
    public static TalonSRX rightDriveMotor2 = new TalonSRX(driveRight2Channel);
    public static TalonSRX rightDriveMotor3 = new TalonSRX(driveRight3Channel);
    public static TalonSRX armMotor1 = new TalonSRX(armMotor1Channel);
    public static TalonSRX armMotor2 = new TalonSRX(armMotor2Channel);
    public static TalonSRX wristMotor = new TalonSRX(wristMotorChannel);

    public static SpeedController clawMotor = new Spark(clawMotorChannel);
    public static SpeedController shelfMotor1 = new Spark(shelfMotor1Channel);
    public static SpeedController shelfMotor2 = new Spark(shelfMotor2Channel);
    public static SpeedController lifterMotor1 = new Spark(lifterMotor1Channel);
    public static SpeedController lifterMotor2 = new Spark(lifterMotor2Channel);


    //    Initialize pneumatic controllers (solenoids)
    public static Solenoid shiftDriveLow = new Solenoid(driveShiftLowChannel);
    public static Solenoid shiftDriveHigh = new Solenoid(driveShiftHighChannel);
    public static Solenoid armBrakeEngage = new Solenoid(armBrakeEngageChannel);
    public static Solenoid armBrakeRelease = new Solenoid(armBrakeReleaseChannel);
    public static Solenoid wristBrakeEngage = new Solenoid(wristBrakeEngageChannel);
    public static Solenoid wristBrakeRelease = new Solenoid(wristBrakeReleaseChannel);


    //    Initialize servos



    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();

    public static AnalogInput wristEncoder = new AnalogInput(wristEncoderChannel);
    public static AnalogInput armEncoder = new AnalogInput(armEncoderChannel);
    public static Encoder driveLeftEncoder = new Encoder(driveLeftEncoderChannelA,driveLeftEncoderChannelB);
    public static Encoder driveRightEncoder = new Encoder(driveRightEncoderChannelA,driveRightEncoderChannelB);
    public static Encoder lifterEncoder = new Encoder(lifterEncoderChannelA,lifterEncoderChannelB);
    public static Encoder shelfEncoder = new Encoder(shelfEncoderChannelA,shelfEncoderChannelB);







}
