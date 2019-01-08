package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class AutoClawMotion extends Command {

    private static Variables.ClawPositions armTargetPosition;
    private static Variables.ClawPositions wristTargetPosition;
    public AutoClawMotion(Variables.ClawPositions armTarget, Variables.ClawPositions wristTarget) {
        super("AutoClawMotion");
        wristTargetPosition = wristTarget;
        armTargetPosition = armTarget;
    }

    protected void initialize() {
        Variables.armAuto = true;
        Variables.wristAuto = true;
        Robot.arm.setSetpoint(armTargetPosition.getPosition());
        Robot.wrist.setSetpoint(wristTargetPosition.getPosition());
        Robot.arm.enable();
        Robot.wrist.enable();
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

