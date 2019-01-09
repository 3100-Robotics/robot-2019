package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
Triggers the shift from low to high gear or vice-versa
 */
public class DriveShift extends Command {


    public DriveShift() {
        super("DriveShift");
    }

    protected void initialize() {
        if(Variables.driveTrainState.getGear().equals("low")) {
            Robot.drive.shiftHigh();
        } else {
            Robot.drive.shiftLow();
        }
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
