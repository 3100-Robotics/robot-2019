package frc.team3100.robot.Arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class AutoArmMotion extends Command {

    private static Variables.ArmPosition targetPosition;
    public AutoArmMotion(Variables.ArmPosition target) {
        super("AutoArmMotion");
        targetPosition = target;
    }

    protected void initialize() {
        Variables.armAuto = true;
        Robot.arm.setSetpoint(targetPosition.getPosition());
        Robot.arm.enable();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}

