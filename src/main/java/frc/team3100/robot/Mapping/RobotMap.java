package frc.team3100.robot.Mapping;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/*
This defines all of the ports the robot will need to access and initialize whatever object is on that port.
 */

public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveControlsChannel = 0;
    private static int techControlsChannel = 1;
    private static int controlBoardChannel = 3;


    //     P C M   C O N T R O L L E R S
    private static int PCM1Channel = 40;
    private static int PCM2Channel = 41;


    //     P W M
    private static int clawMotorChannel = 0;
    private static int shelfMotorsChannel = 1;
    private static int lifterMotorsChannel = 2;


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


    //     M A N I F O L D S (0-7 x 2)
    private static int driveShiftLowChannel = 0;
    private static int driveShiftHighChannel = 1;
    private static int armBrakeEngageChannel = 2;
    private static int armBrakeReleaseChannel = 3;
    private static int wristBrakeEngageChannel = 4;
    private static int wristBrakeReleaseChannel = 5;
    private static int lifterFrontPistonRaiseChannel = 6;
    private static int lifterFrontPistonLowerChannel = 7;

    private static int lifterBackPistonRaiseChannel = 6;
    private static int lifterBackPistonLowerChannel = 7;


    //     A N A L O G
    private static int wristEncoderChannel = 2;
    private static int armEncoderChannel = 3;


    //     D I O
    private static int driveLeftEncoderChannelA = 2;
    private static int driveLeftEncoderChannelB = 3;
    private static int driveRightEncoderChannelA = 4;
    private static int driveRightEncoderChannelB = 5;



    //     D R I V E R   B U T T O N S
    //X B O X
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
    // B O A R D
    public static final int BoardButton1Channel = 1;
    public static final int BoardButton2Channel = 2;
    public static final int BoardButton3Channel = 3;
    public static final int BoardButton4Channel = 4;
    public static final int BoardButton5Channel = 5;
    public static final int BoardButton6Channel = 6;
    public static final int BoardButton7Channel = 7;
    public static final int BoardButton8Channel = 8;
    public static final int BoardButton9Channel = 9;





    //    Initialize XBox Controllers
    public static XBoxStates driveControls = new XBoxStates(driveControlsChannel);
    //public static XBoxStates techControls = new XBoxStates(techControlsChannel);


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
    public static SpeedController shelfMotors = new Spark(shelfMotorsChannel);
    public static SpeedController lifterMotors = new Spark(lifterMotorsChannel);


    //    Initialize Manifolds
    public static Solenoid shiftDriveLow = new Solenoid(PCM1Channel,driveShiftLowChannel);
    public static Solenoid shiftDriveHigh = new Solenoid(PCM1Channel,driveShiftHighChannel);
    public static Solenoid armBrakeEngage = new Solenoid(PCM1Channel,armBrakeEngageChannel);
    public static Solenoid armBrakeRelease = new Solenoid(PCM1Channel,armBrakeReleaseChannel);
    public static Solenoid wristBrakeEngage = new Solenoid(wristBrakeEngageChannel);
    public static Solenoid wristBrakeRelease = new Solenoid(wristBrakeReleaseChannel);


    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();

    public static AnalogInput wristEncoder = new AnalogInput(wristEncoderChannel);
    public static AnalogInput armEncoder = new AnalogInput(armEncoderChannel);
    public static AnalogInput ultrasonic = new AnalogInput(0);
    public static AnalogInput ultrasonic2 = new AnalogInput(1);

    public static Encoder driveLeftEncoder = new Encoder(driveLeftEncoderChannelA,driveLeftEncoderChannelB);
    public static Encoder driveRightEncoder = new Encoder(driveRightEncoderChannelA,driveRightEncoderChannelB);
}