package frc.team3100.robot;

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
    public enum ArmPosition {
        FRONTGROUND(-1000),
        BACKGROUND(1000),
        FRONTSWITCH(-500),
        BACKSWITCH(500);

        private final int position;

        ArmPosition(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }
    }


    public boolean clawOpenState = false;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public static DriveTrainStates driveTrainState = DriveTrainStates.low;
    public double drivePIDRotchange = 0;

}

