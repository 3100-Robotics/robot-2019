package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterActuate extends Command {

    private boolean frontExtend;
    private boolean backExtend;
    private int time = 0;

    public LifterActuate(boolean frontExtend, boolean backExtend) {
        requires(Robot.lifter);
        this.frontExtend = frontExtend;
        this.backExtend = backExtend;
    }

    protected void initialize() {
        Robot.lifter.frontToggle(frontExtend);
        Robot.lifter.backToggle(backExtend);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return RobotMap.lifterFrontUltrasonic.getValue() > 300;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}