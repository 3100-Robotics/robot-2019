package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;


/*
Triggers the shift from low to high gear or vice-versa
 */

public class DriveShift extends Command {
    Button shifter = new JoystickButton(RobotMap.driveControls, RobotMap.aButtonChannel);
    public DriveShift() {
        super("DriveShift");
    }

    protected void initialize() {
        Robot.drive.shiftLow();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return shifter.get();
    }

    protected void end() {
        Robot.drive.shiftHigh();
    }

    protected void interrupted() {

    }
}
