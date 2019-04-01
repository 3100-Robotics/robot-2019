package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Autonomous.AutoLifter;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterSafety extends Command {
    private Command lifting;
    private boolean ran = false;
    public LifterSafety() {
        super("LifterSafety");
    }

    protected void initialize() {
        System.out.println("Running Start");
    }

    protected void execute() {
        // Ensures both buttons are pressed before starting the AutoLifter command
        if(Robot.oi.safetyButton.get() && !ran) {
            lifting = new AutoLifter();
            lifting.start();
            ran = true;
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