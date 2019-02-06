package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterBack extends Command {

    private boolean frontExtend;
    private boolean backExtend;
    private int time = 0;

    public LifterBack(boolean backExtend) {
        super("LifterBack");
        this.backExtend = backExtend;
    }

    protected void initialize() {
        if(Variables.backState) {
            Robot.lifter.backToggle(false);
            Variables.backState = false;
        } else {
            Robot.lifter.backToggle(true);
            Variables.backState = true;
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