package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterActuate extends Command {

    public LifterActuate() {

    }

    protected void initialize() {
        System.out.println("LIFTING!!!");
        // Causes the piston to extend or retract
        if(!Variables.climbExtended) {
            Robot.lifter.extend(true);
            Variables.climbExtended = true;
        } else {
            Robot.lifter.extend(false);
            Variables.climbExtended = false;
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