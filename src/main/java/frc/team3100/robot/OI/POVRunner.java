package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class POVRunner extends Command {
    Command motion;
    public POVRunner() {
        super("POVRunner");

    }

    protected void initialize() {

    }

    protected void execute() {

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
