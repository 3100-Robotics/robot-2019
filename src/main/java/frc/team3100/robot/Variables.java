package frc.team3100.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/*
Stores all of the variables and state values used throughout the robot program.
 */

public class Variables {


    public enum ClawPositions {
        wristBallPickupFront(593+wristSensorOffset),
        wristBallPickupPlayerBack(455+wristSensorOffset),
        wristBallPickupPlayerFront(531+wristSensorOffset),
        wristBallScoreRocketlv2(494+wristSensorOffset),
        wristBallPickupBack(558-81+wristSensorOffset),
        wristBallScoreCargoFront(700+wristSensorOffset),
        wristBallScoreRocketFront(708-81+wristSensorOffset),
        wristBallScoreCargoBack(379+wristSensorOffset),
        wristBallScoreRocketBack(442+wristSensorOffset),
        wristHatchGroundPrep(225+wristSensorOffset),
        wristHatchGround(221+wristSensorOffset),
        wristHatchFront(510+wristSensorOffset),
        wristHatchBack(562+wristSensorOffset),
        wristDefence(800+wristSensorOffset),
        wristHatchPlayerGrab(742+wristSensorOffset),
        wristClimbPrep(250+wristSensorOffset),
        wristClimbMotion(255+wristSensorOffset),

        armBallPickupFront(247+armSensorOffset),
        armBallPickupPlayerBack(625+armSensorOffset),
        armBallPickupPlayerFront(399+armSensorOffset),
        armBallScoreRocketlv2(550+armSensorOffset),
        armBallPickupBack(795+armSensorOffset),
        armBallScoreCargoFront(444+armSensorOffset),
        armBallScoreRocketFront(345+armSensorOffset),
        armBallScoreCargoBack(583+armSensorOffset),
        armBallScoreRocketBack(680+armSensorOffset),
        armHatchGroundPrep(810+armSensorOffset),
        armHatchGround(840+armSensorOffset),
        armHatchFront(260+armSensorOffset),
        armHatchBack(765+armSensorOffset),
        armDefence(460+armSensorOffset),
        armHatchPlayerGrab(651+armSensorOffset),
        armClimbPrep(670+armSensorOffset),
        armClimbMotion(900+armSensorOffset);


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

    public enum startPosition {
        LEFT,
        RIGHT,
        CENTER
    }

    public enum preload {
        HATCH,
        CARGO,
        NONE
    }

    public enum target {
        CARGOSIDE,
        CARGOFRONT,
        ROCKET,
        PLAYERSTATION,
        NONE

    }


    public static double armSensorOffset = 0;
    public static double wristSensorOffset = 81;
    public static double joystickError = 0.2;
    public static boolean armLock = true;
    public static boolean armAuto = false;
    public static boolean wristAuto = false;
    public static boolean driveAuto = true;
    public static boolean climbExtended = false;
    public static boolean hatchExtended = false;
    public static boolean armRunning = false;
    public double drivePIDRotchange = 0;
    public static boolean frontState = false;
    public static boolean backState = false;
    public static boolean lifterRotatePistonEngaged = true;
    public static final Gains kGains_Turning = new Gains( 0.0, 0.0,  0.0, 0.0,200,  1.00 );
    public static final Gains armGains = new Gains(20.0, 0.0, 5.0, 0.0, 200, 1.0);
    public static final Gains wristGains = new Gains(16.0, 0.0, 13.0, 0.0, 200, 1.0);


    public final static double kNeutralDeadband = 0.001;
    // 4098 / 1023
}

