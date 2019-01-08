package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class ClawRotate extends Command {
    private double stickError = 0.3;
    public ClawRotate() {
        super("ClawRotate");
    }

    protected void initialize() {

    }

    protected void execute() {
        if(RobotMap.techControls.getLeftTrigger() > stickError) {
            Robot.claw.wheels(RobotMap.techControls.getLeftTrigger());
        } else if(RobotMap.techControls.getRightTrigger() > stickError) {
            Robot.claw.wheels(-RobotMap.techControls.getRightTrigger());
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
