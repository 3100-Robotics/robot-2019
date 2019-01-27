package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;


/*
Triggers the shift from low to high gear or vice-versa
 */

public class DriveShift extends Command {
    public DriveShift() {
        super("DriveShift");
    }

    protected void initialize() {
        Robot.drive.shiftLow();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return !RobotMap.driveControls.getRightBumper();
    }

    protected void end() {
        Robot.drive.shiftHigh();
    }

    protected void interrupted() {

    }
}
