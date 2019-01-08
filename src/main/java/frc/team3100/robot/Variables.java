package frc.team3100.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Variables {

    public enum RelativeDirection {
        LEFT,
        RIGHT,
        FRONT,
        BACK,
        TOP,
        BOTTOM
    }

    public enum DriveTrainStates {
        high,
        low
    }
    public enum ClawPositions {
        wristFGround(0),
        wristFBall(0),
        wristFMid(0),
        wristFHigh(0),
        wristBHigh(0),
        wristBMid(0),

        armFGround(0),
        armFBall(0),
        armFMid(0),
        armFHigh(0),
        armBHigh(0),
        armBMid(0);

        private final double position;

        ClawPositions(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }



    public static boolean clawOpenState = false;
    public static boolean wristLock = true;
    public static boolean wristAuto = true;
    public static boolean armLock = true;
    public static boolean armAuto = true;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public static DriveTrainStates driveTrainState = DriveTrainStates.low;
    public double drivePIDRotchange = 0;

}

