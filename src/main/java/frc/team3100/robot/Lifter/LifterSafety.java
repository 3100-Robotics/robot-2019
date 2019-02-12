package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Autonomous.AutoLifter;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterSafety extends Command {
    public LifterSafety() {
        super("LifterSafety");
    }

    protected void initialize() {

    }

    protected void execute() {
        if(Robot.oi.safetyButton.get() && Robot.oi.triggerButton.get()) {
            new AutoLifter();

        }
    }

    protected boolean isFinished() {
        return !Robot.oi.safetyButton.get();
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}