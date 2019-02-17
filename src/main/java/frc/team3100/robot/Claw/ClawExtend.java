package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This command takes the two trigger inputs on the Technician's controller and makes the claw motors move accordingly.
 */

public class ClawExtend extends Command {


    public ClawExtend() {
        super("ClawRotate");
    }

    protected void initialize() {
        if(Variables.hatchExtended) {
            Robot.claw.extend(false);
            Variables.hatchExtended = false;
        } else {
            Robot.claw.extend(true);
            Variables.hatchExtended = true;
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
