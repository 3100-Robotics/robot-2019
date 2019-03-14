package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
Waits for ultrasonic input to end the command. A sensor-driven delay for a CommandGroup
 */
public class LifterUltrasonicPauserClose extends Command {

    private Variables.Direction sensor;

    public LifterUltrasonicPauserClose(Variables.Direction sensor) {
        super("LifterUltrasonicPauserClose");
        this.sensor = sensor;
    }

    protected void initialize() {
        System.out.println("Waiting for CLOSE Ultra");
    }

    protected void execute() {
        System.out.println("Waiting for CLOSE Ultra");


    }

    protected boolean isFinished() {
        return(RobotMap.lifterFrontUltrasonic.getValue() < 350);

    }

    protected void end() {

    }

    protected void interrupted() {

    }
}