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


    public static double armSensorOffset = 0;
    public static double joystickError = .2;
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



    public final static double kNeutralDeadband = 0.001;
    public final static int kTimeoutMs = 30;
    public final static int kEncoderUnitsPerRotation = 51711;
    public final static double kTurnTravelUnitsPerRotation = 3600;



    /* Either a 0 or 1 when selecting a PID Index, where 0 is primary and 1 is auxiliary */
    public final static int PID_PRIMARY = 0;
    public final static int PID_TURN = 1;

    /* TalonSRX allows either a 0 or 1 when selecting an ordinal for remote devices [You can have up to 2 devices assigned remotely to a talon/victor] */
    public final static int REMOTE_0 = 0;
    public final static int REMOTE_1 = 1;
    /* TalonSRX Firmware currently supports slots [0, 3] and can be used for either PID Set */
    public final static int SLOT_0 = 0;
    public final static int SLOT_1 = 1;
    public final static int SLOT_2 = 2;
    public final static int SLOT_3 = 3;
    /* ---- Named slots, used to clarify code ---- */
    public final static int kSlot_Distanc = SLOT_0;
    public final static int kSlot_Turning = SLOT_1;
    public final static int kSlot_Velocit = SLOT_2;
    public final static int kSlot_MotProf = SLOT_3;

    /**
     * PID Gains may have to be adjusted based on the responsiveness of control loop.
     * kF: 1023 represents output value to Talon at 100%, 6800 represents Velocity units at 100% output
     * Not all set of Gains are used in this project and may be removed as desired.
     *
     * 	                                    			  kP   kI   kD   kF               Iz    PeakOut */
    public final static Gains kGains_Distanc = new Gains( 0.1, 0.0,  0.0, 0.0,            100,  0.50 );
    public final static Gains kGains_Turning = new Gains( 2.0, 0.0,  4.0, 0.0,            200,  1.00 );
    public final static Gains kGains_Velocit = new Gains( 0.1, 0.0, 20.0, 1023.0/6800.0,  300,  0.50 );
    public final static Gains kGains_MotProf = new Gains( 1.0, 0.0,  0.0, 1023.0/6800.0,  400,  1.00 );

}

