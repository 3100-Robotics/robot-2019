package frc.team3100.robot.Arm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
The command listens for a change in the technician controller's right joystick and
overrides the autonomous control of the claw arm.


MAX V / 100 ms ==
 */

public class ArmMotion extends Command {

    private double speed;

    public ArmMotion() {
        super("ArmMotion");
        requires(Robot.arm);
    }

    protected void initialize() {

    }

    protected void execute() {
        speed = RobotMap.techControls.getLeftStickY();
        speed = speed * speed * ((speed > 0) ? 1 : -1);
        Robot.arm.manualRotation(speed);
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}

