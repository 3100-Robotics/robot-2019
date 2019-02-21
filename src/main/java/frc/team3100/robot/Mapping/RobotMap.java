package frc.team3100.robot.Mapping;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/*
This defines all of the ports the robot will need to access and initialize whatever object is on that port.
 */

public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveControlsChannel = 0;
    private static int techControlsChannel = 1;
    private static int techBoardChannel = 2;


    //     P C M   C O N T R O L L E R S
    private static int PCM1Channel = 41;


    //     P W M
    private static int clawMotorChannel = 9;


    //     C A N
    private static int driveRight1Channel = 1;
    private static int driveRight2Channel = 2;
    private static int driveRight3Channel = 3;
    private static int driveLeft1Channel = 4;
    private static int driveLeft2Channel = 5;
    private static int driveLeft3Channel = 6;
    private static int armMotor1Channel = 7;
    private static int wristMotor2Channel = 8;
    private static int wristMotorChannel = 9;


    //     M A N I F O L D S (ALL SINGLE ACTION)
    private static int lifterFrontPistonExtendChannel = 3;
    private static int lifterBackPistonExtendChannel = 1;
    private static int armBrakeEngageChannel = 0;
    private static int clawHatchReleaseChannel = 2;
    private static int lifterRotationChannel = 5;


    //     A N A L O G
    private static int lifterFrontUltraChannel = 0;
    private static int lifterBackUltraChannel = 1;



    //     D I O




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

    public static final int startButtonChannel = 8;
    public static final int backButtonChannel = 7;

    public static final int rightTriggerChannel = 3;
    public static final int leftTriggerChannel = 2;
    // B O A R D
    public static final int boardButton1Channel = 1;
    public static final int boardButton2Channel = 2;
    public static final int boardButton3Channel = 3;
    public static final int boardButton4Channel = 4;
    public static final int boardButton5Channel = 5;
    public static final int boardButton6Channel = 6;
    public static final int boardButton7Channel = 7;
    public static final int boardButton8Channel = 8;
    public static final int boardButton9Channel = 9;
    public static final int boardButton10Channel = 10;
    public static final int boardButton11Channel = 11;
    public static final int boardButton12Channel = 12;
    public static final int boardButton13Channel = 13;
    public static final int boardButton14Channel = 14;
    public static final int boardButton15Channel = 15;
    public static final int boardButton16Channel = 16;
    public static final int boardButton17Channel = 17;
    public static final int boardButton18Channel = 18;
    public static final int boardButton19Channel = 19;
    public static final int boardButton20Channel = 20;





    //    Initialize XBox Controllers
    public static XBoxStates driveControls = new XBoxStates(driveControlsChannel);
    public static XBoxStates techControls = new XBoxStates(techControlsChannel);
    public static ButtonBoard techBoard = new ButtonBoard(techBoardChannel);


    //    Initialize speed controllers
    public static TalonSRX leftDriveMotor1 = new TalonSRX(driveLeft1Channel);
    public static VictorSPX leftDriveMotor2 = new VictorSPX(driveLeft2Channel); /** Change to TalonSRX for Competition **/
    public static VictorSPX leftDriveMotor3 = new VictorSPX(driveLeft3Channel);

    public static TalonSRX rightDriveMotor1 = new TalonSRX(driveRight1Channel);
    public static VictorSPX rightDriveMotor2 = new VictorSPX(driveRight2Channel);
    public static VictorSPX rightDriveMotor3 = new VictorSPX(driveRight3Channel);

    public static TalonSRX armMotor1 = new TalonSRX(armMotor1Channel);

    public static TalonSRX wristMotor = new TalonSRX(wristMotorChannel);
    public static VictorSPX wristMotor2 = new VictorSPX(wristMotor2Channel);


    public static SpeedController clawMotor = new Spark(clawMotorChannel);


    //    Initialize Solenoids
    public static Solenoid armBrakeEngage = new Solenoid(PCM1Channel,armBrakeEngageChannel);
    public static Solenoid lifterFrontExtend = new Solenoid(PCM1Channel,lifterFrontPistonExtendChannel);
    public static Solenoid lifterBackExtend = new Solenoid(PCM1Channel,lifterBackPistonExtendChannel);
    public static Solenoid lifterRotation = new Solenoid(PCM1Channel,lifterRotationChannel);
    public static Solenoid clawHatchRelease = new Solenoid(PCM1Channel,clawHatchReleaseChannel);


    //    Initialize sensors
    public static AnalogInput lifterFrontUltrasonic = new AnalogInput(lifterFrontUltraChannel);
    public static AnalogInput lifterBackUltrasonic = new AnalogInput(lifterBackUltraChannel);

}