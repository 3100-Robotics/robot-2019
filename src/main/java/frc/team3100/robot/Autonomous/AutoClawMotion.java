package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
    private double armTargetPosition;
    private double wristTargetPosition;

    public AutoClawMotion(Variables.ClawPositions armTarget, Variables.ClawPositions wristTarget) {
        super("AutoClawMotion");
        //requires(Robot.wrist);
        requires(Robot.arm);
        armTargetPosition = armTarget.getPosition();
        //wristTargetPosition = wristTarget.getPosition();

    }

    protected void initialize() {
        Robot.arm.movePosition(armTargetPosition);
        //Robot.wrist.movePosition(wristTargetPosition);
        Variables.armAuto = true;
        //Variables.wristAuto = true;
    }

    protected void execute() {

        /*
        if(armTargetPosition < armLimitZone && Robot.arm.getCurrentPosition() > armLimitZone && !wristSafed) {
            //Robot.wrist.movePosition(Variables.ClawPositions.wristHatchBack.getPosition());
            wristSafed = true;
        } else if(Robot.arm.getCurrentPosition() < armLimitZone && wristSafed) {
            //Robot.wrist.movePosition(wristTargetPosition);
            wristSafed = false;
            wristTargetEntered = true;
        } else if(!wristTargetEntered){
            //Robot.wrist.movePosition(wristTargetPosition);
            wristTargetEntered = true;
        }
        */
    }

    protected boolean isFinished() {
        if( Math.abs(RobotMap.techControls.getLeftStickY()) > .2 /*|| Math.abs(RobotMap.techControls.getRightStickY()) > .2*/) {
            return true;
        } else {
            return false;
        }

    }

    protected void end() {
        Variables.armAuto = false;
        //Variables.wristAuto = false;

    }

    protected void interrupted() {
        //Robot.wrist.stop();
        Robot.arm.stop();
    }
}

