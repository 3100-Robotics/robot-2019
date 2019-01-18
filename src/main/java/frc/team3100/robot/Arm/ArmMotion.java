package frc.team3100.robot.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
The command listens for a change in the technician controller's right joystick and
overrides the autonomous control of the claw arm.


MAX V / 100 ms == 5770
 */

public class ArmMotion extends Command {

    private static double speed = 0;
    private static double joystickError = 0.1;
    public ArmMotion() {
        super("ArmMotion");
        requires(Robot.arm);
    }

    protected void initialize() {

    }

    protected void execute() {
        speed = RobotMap.driveControls.getRightStickY();
        speed *= speed * ((speed > 0) ? 1 : -1);
        SmartDashboard.putNumber("joyInp",speed);
        if(Math.abs(speed) > joystickError) {
            Robot.arm.rotate(speed);
            Variables.armRunning = true;
        }
        if(Variables.armRunning && Math.abs(speed) < joystickError) {
            Robot.arm.rotate(0);
            Variables.armRunning = false;

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

