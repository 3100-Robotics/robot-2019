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
        wristBallPickupFront(0),
        wristBallPickupBack(615),
        wristBallScoreCargoFront(770), // ACTUAL
        wristBallScoreRocketFront(735),
        wristBallScoreCargoBack(512),
        wristBallScoreRocketBack(615),
        wristHatchGroundPrep(485),
        wristHatchGround(485),
        wristHatchFront(685),
        wristHatchBack(695),
        wristDefence(660),

        armBallPickupFront(0),
        armBallPickupBack(805),
        armBallScoreCargoFront(444), // ACTUAL
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
    public static double joystickError = .2;
    public static boolean armLock = true;
    public static boolean armAuto = true;
    public static boolean driveAuto = true;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public static boolean armRunning = false;
    public static DriveTrainStates driveTrainState = DriveTrainStates.low;
    public double drivePIDRotchange = 0;
    public static boolean frontState = false;
    public static boolean backState = false;
    public static final Gains kGains_Turning = new Gains( 0.0, 0.0,  0.0, 0.0,200,  1.00 );
    public static final Gains armGains = new Gains(9.0, 0.0, 1.0, 0.0, 200, 1.0);
    public static final Gains wristGains = new Gains(7.0, 0.0, 0.1, 0.0, 200, 1.0);


    public final static double kNeutralDeadband = 0.001;
    // 4098 / 1023
}

