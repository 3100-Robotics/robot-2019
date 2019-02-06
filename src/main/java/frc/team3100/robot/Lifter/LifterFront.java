package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterFront extends Command {

    private boolean frontExtend;
    private boolean backExtend;
    private int time = 0;

    public LifterFront(boolean frontExtend) {
        super("LifterBack");
        this.frontExtend = frontExtend;
    }

    protected void initialize() {
        if(Variables.frontState) {
            Robot.lifter.frontToggle(false);
            Variables.frontState = false;
        } else {
            Robot.lifter.frontToggle(true);
            Variables.frontState = true;
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