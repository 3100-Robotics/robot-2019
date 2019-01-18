package frc.team3100.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
The command listens for a change in the technician controller's right joystick and
overrides the autonomous control of the claw arm.


MAX V / 100 ms == 5770
 */

public class Reset extends Command {

    public Reset() {
        super("reset");
    }

    protected void initialize() {
        SmartDashboard.putNumber("a",0);
        SmartDashboard.putNumber("b",0);
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

