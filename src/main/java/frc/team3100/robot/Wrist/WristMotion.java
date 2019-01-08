package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class WristMotion extends Command {
    private static double joystickError = 0.3;
    public WristMotion() {
        super("WristMotion");
        requires(Robot.wrist);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(RobotMap.techControls.getLeftStickY() > joystickError) {
            if(Variables.wristAuto) {
                Variables.wristAuto = false;
                Robot.wrist.disable();
            }
            Robot.wrist.rotate(RobotMap.techControls.getRightStickY());
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
