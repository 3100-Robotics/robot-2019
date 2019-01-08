package frc.team3100.robot.Mapping;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveController = 1;

    //     P W M

    //     C A N
    private static int driveLeft1Channel = 4;
    private static int driveLeft2Channel = 5;
    private static int driveLeft3Channel = 6;
    private static int driveRight1Channel = 1;
    private static int driveRight2Channel = 2;
    private static int driveRight3Channel = 3;


    //     P C M
    private static int shiftDriveLowChannel = 0;
    private static int shiftDriveHighChannel = 1;

    //     D I O
    private static int wristEncoderChannelA = 0;
    private static int wristEncoderChannelB = 1;


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


    //    Initialize pneumatic controllers (solenoids)
    public static Solenoid shiftDriveLow = new Solenoid(shiftDriveLowChannel);
    public static Solenoid shiftDriveHigh = new Solenoid(shiftDriveHighChannel);

    //    Initialize servos


    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();
    public static Encoder wristEncoder = new Encoder(wristEncoderChannelA,wristEncoderChannelB);






}
