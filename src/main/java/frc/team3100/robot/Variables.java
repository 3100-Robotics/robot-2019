package frc.team3100.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/*
Stores all of the variables and state values used throughout the robot program.
 */

public class Variables {


    public enum DriveTrainStates {
        high("High"),
        low("Low");
        private final String gear;

        DriveTrainStates(String gear) {
            this.gear = gear;
        }

        public String getGear() {
            return gear;
        }
    }

    public enum ClawPositions {
        wristBallPickupFront(593+28),
        wristBallPickupPlayerBack(0),
        wristBallPickupPlayerFront(0),
        wristBallScoreRockketlv2(0),
        wristBallPickupBack(442+28),
        wristBallScoreCargoFront(597+28),
        wristBallScoreRocketFront(562+28),
        wristBallScoreCargoBack(339+28),
        wristBallScoreRocketBack(442+28),
        wristHatchGroundPrep(312+28),
        wristHatchGround(312+28),
        wristHatchFront(512+28),
        wristHatchBack(512+28),
        wristDefence(487+28),

        armBallPickupFront(247),
        armBallPickupPlayerBack(0),
        armBallPickupPlayerFront(0),
        armBallScoreRockketlv2(0),
        armBallPickupBack(805),
        armBallScoreCargoFront(444),
        armBallScoreRocketFront(345),
        armBallScoreCargoBack(583),
        armBallScoreRocketBack(680),
        armHatchGroundPrep(820),
        armHatchGround(848),
        armHatchFront(274),
        armHatchBack(760),
        armDefence(512);


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
    public static double joystickError = 0.2;
    public static boolean armLock = true;
    public static boolean armAuto = false;
    public static boolean wristAuto = false;
    public static boolean driveAuto = true;
    public boolean climbState = false;
    public static boolean hatchExtended = false;
    public static boolean armRunning = false;
    public static DriveTrainStates driveTrainState = DriveTrainStates.low;
    public double drivePIDRotchange = 0;
    public static boolean frontState = false;
    public static boolean backState = false;
    public static boolean lifterRotatePistonEngaged = true;
    public static final Gains kGains_Turning = new Gains( 0.0, 0.0,  0.0, 0.0,200,  1.00 );
    public static final Gains armGains = new Gains(6.0, 0.0, 1.0, 0.0, 200, 1.0);
    public static final Gains wristGains = new Gains(7.0, 0.0, 0.1, 0.0, 200, 1.0);


    public final static double kNeutralDeadband = 0.001;
    // 4098 / 1023
}

