package frc.team3100.robot.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;


public class CameraScore extends Command {
    private static boolean error = false;
    private static Command clawMotion;

    public CameraScore() {
        super("CameraScore");
        requires(Robot.drive);

    }

    protected void initialize() {

        Robot.table.getEntry("camMode").setNumber(0);
        Robot.table.getEntry("ledMode").setNumber(3);
        if(Robot.vision.getLimelightY() != 0) {
            Robot.drive.enable();
        } else {
            System.out.println("No Target Found");
            error = true;

        }
    }

    protected void execute() {
            if (error) {
                if (Robot.vision.getLimelightY() != 0) {
                    Robot.table.getEntry("camMode").setNumber(0);
                    Robot.table.getEntry("ledMode").setNumber(3);
                    Robot.drive.enable();
                    error = false;
                } else {
                    System.out.println("No Target Found");
                }
            } else {
                System.out.println("Target Found");
                if(Robot.arm.getCurrentPosition() < 360) {
                    Robot.table.getEntry("camMode").setNumber(1);
                    Robot.table.getEntry("ledMode").setNumber(1);
                    Robot.drive.disable();
                    Robot.drive.driveArcade(RobotMap.driveControls.getLeftStickY(),RobotMap.driveControls.getRightStickX());
                }
            }
    }

    protected boolean isFinished() {
        if(!Robot.oi.cameraModeButton.get()) {
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        Robot.table.getEntry("camMode").setNumber(1);
        Robot.table.getEntry("ledMode").setNumber(1);
        Robot.drive.disable();

    }

    protected void interrupted() {

    }
}
