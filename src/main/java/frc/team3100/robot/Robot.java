package frc.team3100.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.Mapping.RobotMap;


public class Robot extends TimedRobot {
    private Command AutoChosen;
    private boolean ran = false;
    // Define subsystems for Commands to access
    public static Compressor compressor;
    public static Drive drive;
    public static Variables varLog;
    public static OI oi;

    // Define variables used later in the Robot class
    public static boolean autoVal;
    public static String gameData;



    public void robotInit() {


        //Creates instances of all of the subsystems for the autonomous to access.
        compressor = new Compressor();
        drive = new Drive();
        varLog = new Variables();

        // ALWAYS initialize OI after subsystems
        oi = new OI();



        RobotMap.gyro.calibrate();
        RobotMap.leftDriveMotor2.follow(RobotMap.leftDriveMotor1);
        RobotMap.leftDriveMotor3.follow(RobotMap.leftDriveMotor1);
        RobotMap.rightDriveMotor2.follow(RobotMap.rightDriveMotor1);
        RobotMap.rightDriveMotor3.follow(RobotMap.rightDriveMotor1);

    }


    public void autonomousInit() {

        RobotMap.gyro.reset();
        // What to run ONCE at the beginning of the autonomous period
        autoVal = true;
        SmartDashboard.putBoolean("autoVal",autoVal);
    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }

    public void teleopInit() {
        // Setting autoVal equal to false so the auto code stops running
        RobotMap.gyro.reset();
        if(autoVal) {
            if(AutoChosen.isRunning()) {
                AutoChosen.cancel();
            }
        }
        autoVal = false;
        SmartDashboard.putBoolean("autoVal",autoVal);


    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();





    }

     public void testInit() {
         autoVal = false;
         SmartDashboard.putBoolean("autoVal",autoVal);

    }

    public void testPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();

    }

    public void disabledInit() {
        ran = false;
        RobotMap.gyro.reset();

    }

    public void disabledPeriodic() {

    }

}

