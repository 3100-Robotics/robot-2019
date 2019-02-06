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
        wristBallPickupBack(0),
        wristBallScoreCargoFront(0),
        wristBallScoreRocketFront(0),
        wristBallScoreCargoBack(0),
        wristBallScoreRocketBack(0),
        wristHatchGround(0),
        wristHatchFront(0),
        wristHatchBack(0),
        wristDefence(0),

        armBallPickupFront(0),
        armBallPickupBack(0),
        armBallScoreCargoFront(0),
        armBallScoreRocketFront(0),
        armBallScoreCargoBack(0),
        armBallScoreRocketBack(0),
        armHatchGround(0),
        armHatchFront(0),
        armHatchBack(0),
        armLimits(0),
        armDefence(0);


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
    public final static Gains kGains_Turning = new Gains( 0.001, 0.0,  0, 0.0,200,  1.00 );
    public final static double kNeutralDeadband = 0.001;

}

