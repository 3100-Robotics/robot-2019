package frc.team3100.robot;

import edu.wpi.first.wpilibj.Spark;

public class RobotMap
{

    public static int driveControlsChannel = 0;

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

    //Sparks
    public static final int driveLeft1Channel = 1;
    public static final int driveRight1Channel = 2;


    public static XBoxStates driveControls = new XBoxStates(driveControlsChannel);

    public static Spark leftDriveMotor = new Spark(driveLeft1Channel);
    public static Spark rightDriveMotor = new Spark(driveRight1Channel);

}
