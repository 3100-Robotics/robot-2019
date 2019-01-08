package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class DriveShift extends Command {


    public DriveShift() {

    }

    protected void initialize() {
        if(Variables.driveTrainState == Variables.DriveTrainStates.low) {
            Robot.drive.shiftHigh();
            Variables.driveTrainState = Variables.DriveTrainStates.high;
        } else {
            Robot.drive.shiftLow();
            Variables.driveTrainState = Variables.DriveTrainStates.low;
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
