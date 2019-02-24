package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
Waits for ultrasonic input to end the command. A sensor-driven delay for a CommandGroup
 */
public class LifterUltrasonicPauser extends Command {

    private Variables.Direction sensor;

    public LifterUltrasonicPauser(Variables.Direction sensor) {
        super("LifterUltrasonicPauser");
        this.sensor = sensor;
    }

    protected void initialize() {

    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return(RobotMap.lifterFrontUltrasonic.getValue() < 300);

    }

    protected void end() {

    }

    protected void interrupted() {

    }
}