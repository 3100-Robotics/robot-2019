package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

/*
    Interfaces the driver's controls to the drive train motors
     */

public class DriveMotion extends Command {


    public DriveMotion() {
        super("DriveMotion");
        requires(Robot.drive);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.drive.driveTank(RobotMap.driveControls.getLeftStickY(), RobotMap.driveControls.getRightStickY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
