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
    public enum ArmPosition {
        MIN(SmartDashboard.getNumber("ArmMin",0)),
        MAX(SmartDashboard.getNumber("ArmMax",5)),
        HIGHMID(SmartDashboard.getNumber("ArmHighMid",3.75)),
        LOWMID(SmartDashboard.getNumber("ArmLowMid",1.25));

        private final double position;

        ArmPosition(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }

    public enum WristPosition {
        MIN(SmartDashboard.getNumber("WristMin",0)),
        MAX(SmartDashboard.getNumber("WristMax",5)),
        HIGHMID(SmartDashboard.getNumber("WristHighMid",3.75)),
        LOWMID(SmartDashboard.getNumber("WristLowMid",1.25));

        private final double position;

        WristPosition(double position) {
            this.position = position;
        }

        public double getPosition() {
            return position;
        }
    }


    public static boolean clawOpenState = false;
    public static boolean wristLock = true;
    public static boolean armLock = true;
    public static boolean armAuto = true;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public static DriveTrainStates driveTrainState = DriveTrainStates.low;
    public double drivePIDRotchange = 0;

}

