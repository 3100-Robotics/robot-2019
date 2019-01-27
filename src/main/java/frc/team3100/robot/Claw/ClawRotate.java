package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This command takes the two trigger inputs on the Technician's controller and makes the claw motors move accordingly.
 */

public class ClawRotate extends Command {

    Button intakeToggle = new JoystickButton(RobotMap.driveControls,RobotMap.leftBumperChannel);

    public ClawRotate() {
        super("ClawRotate");
        requires(Robot.claw);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(RobotMap.driveControls.getLeftTrigger() > Variables.joystickError) {
            Robot.claw.wheels(-RobotMap.driveControls.getLeftTrigger());
        } else if(intakeToggle.get()){
            Robot.claw.wheels(.5);
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
