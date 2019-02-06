package frc.team3100.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
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
    public static Drive drive;
    public static Variables varLog;
    public static Wrist wrist;
    public static Arm arm;
    public static Lifter lifter;
    public static Claw claw;
    public static OI oi;
    public static Compressor compressor;

    // Define variables used later in the Robot class
    public static boolean autoVal;

    public static NetworkTable table;

    public void robotInit() {
        //Creates instances of all of the subsystems for the autonomous to access.
        compressor = new Compressor(41);
        compressor.setClosedLoopControl(true);
        drive = new Drive();
        varLog = new Variables();
        wrist = new Wrist();
        arm = new Arm();
        claw = new Claw();
        lifter = new Lifter();

        // ALWAYS initialize OI after subsystems
        oi = new OI();

        table = NetworkTableInstance.getDefault().getTable("limelight");

        RobotMap.gyro.calibrate();

        new TalonConfig().configure();



    }


    public void autonomousInit() {
        autoVal = true;

    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }

    public void teleopInit() {
        Dashboard.initDashboard();
        if(autoVal) {
            if(AutoChosen.isRunning()) {
                AutoChosen.cancel();
            }
        }
        autoVal = false;


    }

    public void teleopPeriodic() {
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

