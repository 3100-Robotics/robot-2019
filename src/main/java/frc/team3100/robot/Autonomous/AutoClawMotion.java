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

    private int armTargetPosition;
    private int wristTargetPosition;

    public AutoClawMotion(Variables.ClawPositions armTarget, Variables.ClawPositions wristTarget) {
        super("AutoClawMotion");
        armTargetPosition = armTarget.getPosition();
        wristTargetPosition = wristTarget.getPosition();
    }

    protected void initialize() {
        Robot.arm.movePosition(armTargetPosition);
        if(armTargetPosition > 3000 + Variables.armSensorOffset) {

        } else if(armTargetPosition > 2500 + Variables.armSensorOffset) {

        }
        Variables.armAuto = true;


    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        if(Math.abs(Robot.arm.getCurrentPosition() - armTargetPosition) < 10 &&
                Math.abs(Robot.wrist.getCurrentPosition() - wristTargetPosition) < 10) {
            return true;
        } else {
            return false;
        }
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}

