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
    private String targetLoc;

    public AutoClawMotion(String target) {
        super("AutoClawMotion");
        requires(Robot.wrist);
        requires(Robot.arm);
        this.targetLoc = target;


    }

    protected void initialize() {
        if(targetLoc.equals("DEF")) {
            armTargetPosition = Robot.presetValues[21];
            wristTargetPosition = Robot.presetValues[20];
        } else if(targetLoc.equals("ballRocketBack")) {
            armTargetPosition = Robot.presetValues[11];
            wristTargetPosition = Robot.presetValues[10];
        } else if(targetLoc.equals("ballRocketFront")) {
            armTargetPosition = Robot.presetValues[9];
            wristTargetPosition = Robot.presetValues[8];
        } else if(targetLoc.equals("ballCargoFront")) {
            armTargetPosition = Robot.presetValues[5];
            wristTargetPosition = Robot.presetValues[4];
        } else if(targetLoc.equals("ballCargoBack")) {
            armTargetPosition = Robot.presetValues[7];
            wristTargetPosition = Robot.presetValues[6];
        } else if(targetLoc.equals("ballRocket2Back")) {
            armTargetPosition = Robot.presetValues[13];
            wristTargetPosition = Robot.presetValues[12];
        } else if(targetLoc.equals("ballPickupFront")) {
            armTargetPosition = Robot.presetValues[1];
            wristTargetPosition = Robot.presetValues[0];
        } else if(targetLoc.equals("ballPickupBack")) {
            armTargetPosition = Robot.presetValues[3];
            wristTargetPosition = Robot.presetValues[2];
        } else if(targetLoc.equals("hatchScoreFront")) {
            armTargetPosition = Robot.presetValues[15];
            wristTargetPosition = Robot.presetValues[14];
        } else if(targetLoc.equals("hatchScoreBack")) {
            armTargetPosition = Robot.presetValues[17];
            wristTargetPosition = Robot.presetValues[16];
        } else if(targetLoc.equals("hatchScoreRocketLv2")) {
            armTargetPosition = Robot.presetValues[19];
            wristTargetPosition = Robot.presetValues[18];
        }

        if(!Robot.oi.presetTuning.get()) {
            Robot.arm.movePosition(armTargetPosition);
            Robot.wrist.movePosition(wristTargetPosition);
            Variables.armAuto = true;
            Variables.wristAuto = true;
        }
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
        if(Math.abs(RobotMap.techControls.getLeftStickY()) > .2 || Math.abs(RobotMap.techControls.getRightStickY()) > .2 ||
                (Math.abs(armTargetPosition - 512) < 10 && Math.abs(armTargetPosition - RobotMap.armMotor1.getSelectedSensorPosition()) < 15) && Math.abs(wristTargetPosition - RobotMap.wristMotor.getSelectedSensorPosition()) < 10) {
            return true;
        } else {
            return false;
        }

    }

    protected void end() {
        Variables.armAuto = false;
        Variables.wristAuto = false;

    }

    protected void interrupted() {
        //Robot.wrist.stop();
        Robot.arm.stop();
    }
}

