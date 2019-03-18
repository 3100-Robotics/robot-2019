package frc.team3100.robot.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Autonomous.AutoLifter;
import frc.team3100.robot.Robot;


public class GenerateSpline extends Command {


    public GenerateSpline() {
        super("GenerateSpline");
    }

    protected void initialize() {
        System.out.println("Generating Spline Path");
    }

    protected void execute() {
        Robot.vision.generateSpline();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}