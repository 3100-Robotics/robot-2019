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
    private Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    private Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.homeButtonChannel);
    private boolean began = false;
    public LifterSafety() {
        super("LifterSafety");
    }

    protected void initialize() {

    }

    protected void execute() {
        if(safetyButton.get() && triggerButton.get()) {
            new AutoLifter();

        }
    }

    protected boolean isFinished() {
        return !safetyButton.get();
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}