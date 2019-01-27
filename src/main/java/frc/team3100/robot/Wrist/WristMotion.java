package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
Overrides the auto motion of the claw when the technician's right sick exceeds a certain value.
 */

public class WristMotion extends Command {
    private double speed;
    public WristMotion() {
        super("WristMotion");
        requires(Robot.wrist);
    }

    protected void initialize() {

    }

    protected void execute() {
        speed = RobotMap.techControls.getRightStickY();
        speed = speed * speed * ((speed > 0) ? 1 : -1);
        Robot.wrist.manualRotation(speed);

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
