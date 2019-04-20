package frc.team3100.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Trajectory;


/*
Stores all of the variables and state values used throughout the robot program.
 */

public class Variables {


    public enum ClawPositions {
        wristBallPickupFront(Robot.presetValues[0]), // 772-148+wristSensorOffset
        wristBallPickupBack(Robot.presetValues[2]), // 544-148+wristSensorOffset

        wristBallScoreCargoFront(Robot.presetValues[4]), // 700+wristSensorOffset
        wristBallScoreCargoBack(Robot.presetValues[6]), // 345+wristSensorOffset

        wristBallScoreRocketFront(Robot.presetValues[8]), // 729-148+wristSensorOffset
        wristBallScoreRocketBack(Robot.presetValues[10]), // 442+wristSensorOffset
        wristBallScoreRocketlv2(Robot.presetValues[12]), // 699-148+wristSensorOffset



        wristHatchFront(Robot.presetValues[14]), // 660-168+wristSensorOffset
        wristHatchBack(Robot.presetValues[16]), // 663-148+wristSensorOffset
        wristHatchScoreRocketLv2(Robot.presetValues[18]), // 538-168+wristSensorOffset



        wristDefence(Robot.presetValues[20]), // 800+wristSensorOffset

        wristClimbPrep(Robot.presetValues[22]), // 430-148+wristSensorOffset
        wristClimbMotion(Robot.presetValues[24]), // 255+wristSensorOffset







        armBallPickupFront(Robot.presetValues[1]), // 234-54+armSensorOffset
        armBallPickupBack(Robot.presetValues[3]), // 858-54+armSensorOffset

        armBallScoreCargoFront(Robot.presetValues[5]), // 444+armSensorOffset
        armBallScoreCargoBack(Robot.presetValues[7]), // 540+armSensorOffset

        armBallScoreRocketFront(Robot.presetValues[9]), // 358-54+armSensorOffset
        armBallScoreRocketBack(Robot.presetValues[11]), // 680+armSensorOffset
        armBallScoreRocketlv2(Robot.presetValues[13]), // 514-54+armSensorOffset



        armHatchFront(Robot.presetValues[15]), // 273-45+armSensorOffset
        armHatchBack(Robot.presetValues[17]), // 844-45+armSensorOffset
        armHatchScoreRocketLv2(Robot.presetValues[19]), // 532+armSensorOffset



        armDefence(Robot.presetValues[21]), // 460+armSensorOffset

        armClimbPrep(Robot.presetValues[23]), // 762-54+armSensorOffset
        armClimbMotion(Robot.presetValues[25]); // 980-54+armSensorOffset


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
    public static boolean fileEmpty = false;

    public final static double kNeutralDeadband = 0.001;
    // 4098 / 1023
}

