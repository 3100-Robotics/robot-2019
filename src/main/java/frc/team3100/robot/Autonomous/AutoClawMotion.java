package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This command takes a wrist and arm input and tells the respective subsystems to move to that location,
starting the autonomous motion.
 */

public class AutoClawMotion extends Command {

    private static Variables.ClawPositions armTargetPosition;
    public AutoClawMotion(Variables.ClawPositions armTarget) {
        super("AutoClawMotion");
        armTargetPosition = armTarget;
    }

    protected void initialize() {

        Variables.armAuto = true;
        Robot.arm.movePosition(armTargetPosition.getPosition());
        SmartDashboard.putNumber("a",1);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        SmartDashboard.putNumber("a",2);
    }

    protected void interrupted() {

    }
}

