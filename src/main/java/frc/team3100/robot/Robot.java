package frc.team3100.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Arm.Arm;
import frc.team3100.robot.Autonomous.AutoMaster;
import frc.team3100.robot.Brake.Brake;
import frc.team3100.robot.Claw.Claw;
import frc.team3100.robot.Drivetrain.Drive;
import frc.team3100.robot.Lifter.Lifter;
import frc.team3100.robot.Limelight.LimelightCalculation;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Mapping.TalonConfig;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.OI.OI;
import frc.team3100.robot.OI.POVRunner;
import frc.team3100.robot.Wrist.Wrist;
import org.opencv.core.Core;
import org.opencv.core.Mat;

import static org.opencv.core.CvType.CV_32F;


/*
Initializes all subsystems and runs the scheduler to enable the use of commands.
 */
public class Robot extends TimedRobot {

    private Command AutoRunner;

    // Define subsystems for Commands to access
    private SendableChooser<Variables.startPosition> autoStart;
    private SendableChooser<Variables.preload> preload;
    private SendableChooser<Variables.target> autoTarget;
    public static Drive drive;
    public static Variables varLog;
    public static Wrist wrist;
    public static Arm arm;
    public static Lifter lifter;
    public static Claw claw;
    public static Brake brake;
    public static LimelightCalculation vision;
    public static AHRS ahrs;
    public static POVRunner povRunner;
    public static OI oi;
    public static Compressor compressor;


    // Define variables used later in the Robot class
    public static boolean autoVal;

    public static NetworkTable table;

    public void robotInit() {


        table = NetworkTableInstance.getDefault().getTable("limelight");
        table.getEntry("camMode").setNumber(0);
        table.getEntry("ledMode").setNumber(0);

        autoStart = new SendableChooser<>();
        autoStart.addOption("Left", Variables.startPosition.LEFT);
        autoStart.addOption("Center", Variables.startPosition.CENTER);
        autoStart.addOption("Right", Variables.startPosition.RIGHT);
        SmartDashboard.putData(autoStart);

        preload = new SendableChooser<>();
        preload.addOption("Hatch", Variables.preload.HATCH);
        preload.addOption("Cargo", Variables.preload.CARGO);
        SmartDashboard.putData(preload);

        autoTarget = new SendableChooser<>();
        autoTarget.addOption("None", Variables.target.NONE);
        autoTarget.addOption("CargoFront", Variables.target.CARGOFRONT);
        autoTarget.addOption("Cargo Side", Variables.target.CARGOSIDE);
        autoTarget.addOption("Rocket",Variables.target.ROCKET);
        SmartDashboard.putData(autoTarget);


        //Creates instances of all of the subsystems for the autonomous to access.
        compressor = new Compressor(41);
        compressor.setClosedLoopControl(true);
        drive = new Drive();
        varLog = new Variables();
        wrist = new Wrist();
        arm = new Arm();
        brake = new Brake();
        claw = new Claw();
        vision = new LimelightCalculation();
        lifter = new Lifter();
        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
            System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
        }
        povRunner = new POVRunner();

        // ALWAYS initialize OI after subsystems
        oi = new OI();



        new TalonConfig().configure();
        new Thread(() -> {

            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(320, 480);

            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("test", 320, 480);
            MjpegServer server = new MjpegServer("lime",5800);
            Mat source = new Mat(320,480,CV_32F);
            source = source.zeros(320,480,CV_32F);

            Mat output = new Mat(320,480,CV_32F);

            while (!Thread.interrupted()) {
                cvSink.setEnabled(true);
                cvSink.grabFrame(source, 30);
                if (RobotMap.armMotor1.getSelectedSensorPosition() > 512) {
                    Core.flip(source, output, 1);
                } else {
                    source = output;
                }
                outputStream.putFrame(output);
            }
        }).start();


        Robot.drive.disable();
    }


    public void autonomousInit() {
        povRunner.start();
        autoVal = true;
        AutoRunner = new AutoMaster(autoStart.getSelected(),preload.getSelected(),autoTarget.getSelected());
        AutoRunner.start();

    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }

    public void teleopInit() {
        if(!povRunner.isRunning()) {
            povRunner.start();
        }

        if(AutoRunner != null) {
            if (AutoRunner.isRunning()) {
                AutoRunner.cancel();
            }
        }
        autoVal = false;

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
    }

     public void testInit() {
         if(AutoRunner != null) {
             if (AutoRunner.isRunning()) {
                 AutoRunner.cancel();
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
        Dashboard.initDashboard();
        Dashboard.updateDashboard();
    }

    public void disabledPeriodic() {
        Dashboard.updateDashboard();
    }

}

