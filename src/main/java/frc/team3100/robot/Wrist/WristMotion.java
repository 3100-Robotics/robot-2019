package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
Overrides the auto motion of the claw when the technician's right sick exceeds a certain value.
 */

public class WristMotion extends Command {
    private static double joystickError = 0.3;
    public WristMotion() {
        super("WristMotion");
        requires(Robot.wrist);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(RobotMap.driveControls.getLeftStickY() > joystickError) {
            if(Variables.wristAuto) {
                Variables.wristAuto = false;
                Robot.wrist.disable();
            }
            Robot.wrist.rotate(RobotMap.driveControls.getRightStickY());
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
