package frc.team3100.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Arm.Arm;
import frc.team3100.robot.Claw.Claw;
import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.Lifter.Lifter;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Wrist.Wrist;

/*
Initializes all subsystems and runs the scheduler to enable the use of commands.
 */
public class Robot extends TimedRobot {
    private Command AutoChosen;

    // Define subsystems for Commands to access
    public static Compressor compressor;
    public static Drive drive;
    public static Variables varLog;
    public static Wrist wrist;
    public static Arm arm;
    public static Lifter lifter;
    public static Claw claw;
    public static OI oi;

    // Define variables used later in the Robot class
    public static boolean autoVal;
    public static String gameData;

    public static NetworkTable table;


    public void robotInit() {

        //Creates instances of all of the subsystems for the autonomous to access.
        compressor = new Compressor();
        drive = new Drive();
        varLog = new Variables();
        wrist = new Wrist();
        arm = new Arm();
        claw = new Claw();
        lifter = new Lifter();

        // ALWAYS initialize OI after subsystems
        oi = new OI();

        table = NetworkTableInstance.getDefault().getTable("limelight");
        table.getEntry("ledMode").setNumber(3);
        table.getEntry("camMode").setNumber(0);
        table.getEntry("pipeline").setNumber(0);

        RobotMap.gyro.calibrate();
        RobotMap.leftDriveMotor2.follow(RobotMap.leftDriveMotor1);
        RobotMap.leftDriveMotor3.follow(RobotMap.leftDriveMotor1);
        RobotMap.rightDriveMotor2.follow(RobotMap.rightDriveMotor1);
        RobotMap.rightDriveMotor3.follow(RobotMap.rightDriveMotor1);
        RobotMap.armMotor2.follow(RobotMap.armMotor1);

        RobotMap.rightDriveMotor3.setInverted(true);
        RobotMap.leftDriveMotor3.setInverted(false);
        RobotMap.leftDriveMotor2.setInverted(false);
        RobotMap.leftDriveMotor1.setInverted(true);



    }


    public void autonomousInit() {
        // What to run ONCE at the beginning of the autonomous period
        autoVal = true;

    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }

    public void teleopInit() {
        // Setting autoVal equal to false so the auto code stops running
        Dashboard.initDashboard();
        if(autoVal) {
            if(AutoChosen.isRunning()) {
                AutoChosen.cancel();
            }
        }
        autoVal = false;


    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();





    }

     public void testInit() {
         if(autoVal) {
             if(AutoChosen.isRunning()) {
                 AutoChosen.cancel();
             }
         }
         autoVal = false;

    }

    public void testPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();

    }

    public void disabledInit() {
        SmartDashboard.putNumber("a",0);
        SmartDashboard.putNumber("b",0);
    }

    public void disabledPeriodic() {
        Dashboard.updateDashboard();
    }

}

