package frc.team3100.robot.Wrist;

import com.ctre.phoenix.motorcontrol.ControlMode;
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
        if(Math.abs(speed) < .2 && !Variables.wristAuto) {
            Robot.wrist.manualRotation(.31 * (RobotMap.armMotor1.getSensorCollection().getAnalogIn() > 512 ? 1:-1));
        } else {
            Robot.wrist.manualRotation(speed);
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
