package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

/*
    This needs work. Must implement driving-straight PID and driving set distances
     */

public class AutoClawClimbMotor extends Command {

    public AutoClawClimbMotor() {
        super("AutoClawClimbMotor");
        requires(Robot.claw);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.claw.wheels(.7,-.7);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}