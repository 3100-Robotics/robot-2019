package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Waits for ultrasonic input to end the command. A sensor-driven delay for a CommandGroup
 */
public class LifterUltrasonicPauserFar extends Command {

    private Variables.Direction sensor;
    private int time = 0;

    public LifterUltrasonicPauserFar(Variables.Direction sensor) {
        super("LifterUltrasonicPauserFar");
        this.sensor = sensor;
    }

    protected void initialize() {
        System.out.println("Waiting for FAR Ultra");
    }

    protected void execute() {
        System.out.println("Waiting for FAR Ultra");
        time += 1;

    }

    protected boolean isFinished() {
        return(RobotMap.lifterFrontUltrasonic.getValue() > 400);

    }

    protected void end() {

    }

    protected void interrupted() {

    }
}