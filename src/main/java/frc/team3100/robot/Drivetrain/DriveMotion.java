package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

public class DriveMotion extends Command {


    public DriveMotion() {
        super("DriveMotion");
        requires(Robot.drive);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.drive.driveArcade(RobotMap.driveControls.getLeftStickY(), RobotMap.driveControls.getRightStickX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
