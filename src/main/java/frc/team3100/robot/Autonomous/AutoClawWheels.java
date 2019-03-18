package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
    This needs work. Must implement driving-straight PID and driving set distances
     */

public class AutoClawWheels extends Command {
    private int time = 0;
    public AutoClawWheels() {
        super("AutoClawWheels");
        requires(Robot.claw);
    }

    protected void initialize() {
        System.out.println("Claw Motors Starting");
    }

    protected void execute() {
        if(Variables.climbExtended) {
            Robot.claw.wheels(-.7, .7);
        } else {
            Robot.claw.wheels(0,0);
        }
        time += 1;
    }

    protected boolean isFinished() {
        if((time > 40) || RobotMap.driveControls.getLeftTrigger() > .2 || RobotMap.driveControls.getRightTrigger() > .2) {
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        Robot.claw.wheels(0,0);
        System.out.println("ClawMotor OFF");

    }

    protected void interrupted() {

    }
}