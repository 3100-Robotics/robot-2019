package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
    This needs work. Must implement driving-straight PID and driving set distances
     */

public class AutoDrive extends Command {
    private double speed;
    private double rotate;

    public AutoDrive(double speed, double rotate) {
        super("DriveMotion");
        requires(Robot.drive);
        this.speed = speed;
        this.rotate = rotate;
    }

    protected void initialize() {
        System.out.println("Driving Starting");

    }

    protected void execute() {
        if(Variables.climbExtended) {
            Robot.drive.driveArcade(speed, rotate);
        } else {
            Robot.drive.stop();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.drive.driveArcade(0,0);
        System.out.println("Wheels OFF");
    }

    protected void interrupted() {

    }
}