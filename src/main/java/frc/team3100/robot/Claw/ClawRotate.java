package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class ClawRotate extends Command {
    private double joystickError = 0.3;
    public ClawRotate() {
        super("ClawRotate");
        requires(Robot.claw);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(RobotMap.techControls.getLeftTrigger() > joystickError) {
            Robot.claw.wheels(RobotMap.techControls.getLeftTrigger());
        } else if(RobotMap.techControls.getRightTrigger() > joystickError) {
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
