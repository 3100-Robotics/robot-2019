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
        wristFGround(0),
        wristFBall(0),
        wristFMid(0),
        wristFHigh(0),
        wristBHigh(0),
        wristBMid(0),

        armFGround(0),
        armFBall(0),
        armFMid(0),
        armFHigh(4096),
        armBHigh(-4096),
        armBMid(0);

        private final int position;

        ClawPositions(int position) {
            this.position = position;
        }

        public int getPosition() {
            return position;
        }
    }



    public static boolean clawOpenState = false;
    public static boolean wristLock = true;
    public static boolean wristAuto = true;
    public static boolean armLock = true;
    public static boolean armAuto = true;
    public static boolean driveAuto = true;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public static boolean armRunning = false;
    public static DriveTrainStates driveTrainState = DriveTrainStates.low;
    public double drivePIDRotchange = 0;

}

