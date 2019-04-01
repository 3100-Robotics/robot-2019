package frc.team3100.robot.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Autonomous.AutoLifter;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

import static frc.team3100.robot.Variables.leftRoute;


public class GenerateSpline extends Command {


    public GenerateSpline() {
        super("GenerateSpline");
    }

    protected void initialize() {
        System.out.println("Generating Spline Path");
        leftRoute = null;
        Variables.rightRoute = null;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        if(leftRoute != null ) {
            SmartDashboard.putString("ABC","Trajectory Length: " + leftRoute.length());
            System.out.println("Completed Spline Path Generation");
            return true;
        } else {
            return false;
        }
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}