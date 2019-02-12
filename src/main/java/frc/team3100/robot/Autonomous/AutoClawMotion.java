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
    private Button stopper = new JoystickButton(RobotMap.driveControls,RobotMap.bButtonChannel);
    private double armTargetPosition;
    private double wristTargetPosition;
    private boolean wristSafed = false;
    private boolean wristTargetEntered = false;

    public AutoClawMotion(Variables.ClawPositions armTarget, Variables.ClawPositions wristTarget) {
        super("AutoClawMotion");
        requires(Robot.wrist);
        requires(Robot.claw);
        armTargetPosition = armTarget.getPosition();
        wristTargetPosition = wristTarget.getPosition();

    }

    protected void initialize() {
        wristSafed = false;
        Robot.arm.movePosition(armTargetPosition);
        Robot.wrist.movePosition(wristTargetPosition);
        Variables.armAuto = true;
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
        /*if(Math.abs(Robot.arm.getCurrentPosition() - armTargetPosition) < 10 &&
                Math.abs(Robot.wrist.getCurrentPosition() - wristTargetPosition) < 10) {
            return true;
        } else {
            return false;
        }*/
        return true;
    }

    protected void end() {
        Variables.armAuto = false;
    }

    protected void interrupted() {
        Robot.wrist.stop();
        Robot.arm.stop();
    }
}

