package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class WristMotion extends Command {

    public WristMotion() {
        super("WristMotion");
        requires(Robot.wrist);
    }

    protected void initialize() {

    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
