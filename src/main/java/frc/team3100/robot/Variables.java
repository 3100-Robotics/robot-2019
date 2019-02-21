package frc.team3100.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/*
Stores all of the variables and state values used throughout the robot program.
 */

public class Variables {


    public enum ClawPositions {
        wristBallPickupFront(593+wristSensorOffset),
        wristBallPickupPlayerBack(0+wristSensorOffset),
        wristBallPickupPlayerFront(0+wristSensorOffset),
        wristBallScoreRockketlv2(0+wristSensorOffset),
        wristBallPickupBack(442+wristSensorOffset),
        wristBallScoreCargoFront(597+wristSensorOffset),
        wristBallScoreRocketFront(562+wristSensorOffset),
        wristBallScoreCargoBack(339+wristSensorOffset),
        wristBallScoreRocketBack(442+wristSensorOffset),
        wristHatchGroundPrep(312+wristSensorOffset),
        wristHatchGround(312+wristSensorOffset),
        wristHatchFront(532+wristSensorOffset),
        wristHatchBack(522+wristSensorOffset),
        wristDefence(487+wristSensorOffset),
        wristHatchPlayerGrab(742+wristSensorOffset),

        armBallPickupFront(247+armSensorOffset),
        armBallPickupPlayerBack(0+armSensorOffset),
        armBallPickupPlayerFront(0+armSensorOffset),
        armBallScoreRockketlv2(0+armSensorOffset),
        armBallPickupBack(805+armSensorOffset),
        armBallScoreCargoFront(444+armSensorOffset),
        armBallScoreRocketFront(345+armSensorOffset),
        armBallScoreCargoBack(583+armSensorOffset),
        armBallScoreRocketBack(680+armSensorOffset),
        armHatchGroundPrep(810+armSensorOffset),
        armHatchGround(840+armSensorOffset),
        armHatchFront(290+armSensorOffset),
        armHatchBack(785+armSensorOffset),
        armDefence(512+armSensorOffset),
        armHatchPlayerGrab(651+armSensorOffset);


        private final double position;

        ClawPositions(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }

    public enum Direction {
        FRONT,
        BACK,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }
    public static double armSensorOffset = 0;
    public static double wristSensorOffset = 18;
    public static double joystickError = 0.2;
    public static boolean armLock = true;
    public static boolean armAuto = false;
    public static boolean wristAuto = false;
    public static boolean driveAuto = true;
    public boolean climbState = false;
    public static boolean hatchExtended = false;
    public static boolean armRunning = false;
    public double drivePIDRotchange = 0;
    public static boolean frontState = false;
    public static boolean backState = false;
    public static boolean lifterRotatePistonEngaged = true;
    public static final Gains kGains_Turning = new Gains( 0.0, 0.0,  0.0, 0.0,200,  1.00 );
    public static final Gains armGains = new Gains(15.0, 0.0, 5.0, 0.0, 200, 1.0);
    public static final Gains wristGains = new Gains(15.0, 0.0, 5.0, 0.0, 200, 1.0);


    public final static double kNeutralDeadband = 0.001;
    // 4098 / 1023
}

