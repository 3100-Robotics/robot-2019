package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class POVRunner extends Command {

    public POVRunner() {
        super("POVRunner");

    }

    protected void initialize() {

    }

    protected void execute() {
        if(RobotMap.driveControls.getPOVD()) {

        } else if(RobotMap.driveControls.getPOVL()) {

        }else if(RobotMap.driveControls.getPOVU()) {

        }else if(RobotMap.driveControls.getPOVR()) {

        }

        if(RobotMap.techControls.getPOVD()) {
            new AutoClawMotion(Variables.ClawPositions.armHatchGround,Variables.ClawPositions.wristHatchGround);
        } else if(RobotMap.techControls.getPOVL()) {
            new AutoClawMotion(Variables.ClawPositions.armHatchFront,Variables.ClawPositions.wristHatchFront);
        } else if(RobotMap.techControls.getPOVU()) {
            new AutoClawMotion(Variables.ClawPositions.armHatchGroundPrep,Variables.ClawPositions.wristHatchGroundPrep);
        } else if(RobotMap.techControls.getPOVR()) {
            new AutoClawMotion(Variables.ClawPositions.armHatchBack,Variables.ClawPositions.wristHatchBack);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        System.out.println("POV Control Disabled");
    }

    protected void interrupted() {

    }
}
