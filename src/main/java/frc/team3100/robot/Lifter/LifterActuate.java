package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This will trigger whatever lifting mechanism we decide on to lift
 */
public class LifterActuate extends Command {

    private boolean extend;
    private int time = 0;

    public LifterActuate(boolean extend) {
        this.extend = extend;
    }

    protected void initialize() {
        // Causes the piston to extend or retract depending on input
        Robot.lifter.extend(extend);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        // Finishes when the ultrasonic says the robot is in the air
        return RobotMap.lifterFrontUltrasonic.getValue() > 300;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}