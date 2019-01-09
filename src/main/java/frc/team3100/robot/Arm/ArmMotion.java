package frc.team3100.robot.Arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
The command listens for a change in the technician controller's right joystick and
overrides the autonomous control of the claw arm.
 */

public class ArmMotion extends Command {
    private static double joystickError = 0.3;
    public ArmMotion() {
        super("ArmMotion");
        requires(Robot.arm);
    }

    protected void initialize() {

    }

    protected void execute() {

        if(RobotMap.techControls.getRightStickY() > joystickError) {
            if(Variables.armAuto) {
                Variables.armAuto = false;
                Robot.arm.disable();
            }
            Robot.arm.rotate(RobotMap.techControls.getRightStickY());
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

