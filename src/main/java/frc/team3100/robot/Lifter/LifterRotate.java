package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

import static frc.team3100.robot.Variables.lifterRotatePistonEngaged;


/*
Triggers the shift from low to high gear or vice-versa
 */

public class LifterRotate extends Command {
    public LifterRotate() {
        super("LifterRotate");
    }

    protected void initialize() {
        if(lifterRotatePistonEngaged) {
            Robot.lifter.rotate(true);
            lifterRotatePistonEngaged = false;
        } else {
            Robot.lifter.rotate(false);
            lifterRotatePistonEngaged = true;
        }
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return !Robot.oi.lifterRotationButton.get();
    }

    protected void end() {
        Robot.lifter.rotate(false);
    }

    protected void interrupted() {

    }
}
