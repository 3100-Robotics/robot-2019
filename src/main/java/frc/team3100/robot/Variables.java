package frc.team3100.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Trajectory;


/*
Stores all of the variables and state values used throughout the robot program.
 */

public class Variables {


    public enum ClawPositions {
        //wristBallPickupPlayerBack(455+wristSensorOffset),
        //wristBallPickupPlayerFront(531+wristSensorOffset),
        wristBallPickupFront(772-148+wristSensorOffset),
        wristBallPickupBack(544-148+wristSensorOffset),


        wristBallScoreCargoFront(700+wristSensorOffset),
        wristBallScoreCargoBack(345+wristSensorOffset),

        wristBallScoreRocketFront(729-148+wristSensorOffset),
        wristBallScoreRocketBack(442+wristSensorOffset),
        wristBallScoreRocketlv2(699-148+wristSensorOffset),


        wristHatchFront(660-168+wristSensorOffset),
        wristHatchBack(663-148+wristSensorOffset),
        wristHatchScoreRocketLv2(538-168+wristSensorOffset),

        wristDefence(800+wristSensorOffset),

        wristClimbPrep(430-148+wristSensorOffset),
        wristClimbMotion(255+wristSensorOffset),





        //armBallPickupPlayerBack(625+armSensorOffset),
        //armBallPickupPlayerFront(399+armSensorOffset),

        armBallPickupFront(234-54+armSensorOffset),
        armBallPickupBack(858-54+armSensorOffset),

        armBallScoreCargoFront(444+armSensorOffset),
        armBallScoreCargoBack(540+armSensorOffset),

        armBallScoreRocketFront(358-54+armSensorOffset),
        armBallScoreRocketBack(680+armSensorOffset),
        armBallScoreRocketlv2(514-54+armSensorOffset),

        armHatchFront(273-45+armSensorOffset),
        armHatchBack(844-45+armSensorOffset),
        armHatchScoreRocketLv2(532+armSensorOffset),

        armDefence(460+armSensorOffset),

        armClimbPrep(762-54+armSensorOffset),
        armClimbMotion(980-54+armSensorOffset);


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

    public static double armTargetLoc = 0;
    public static double armSensorOffset = 54;
    public static double wristSensorOffset = 148;
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
    public static Trajectory leftRoute = null;
    public static Trajectory rightRoute = null;

    public final static double kNeutralDeadband = 0.001;
    // 4098 / 1023
}

