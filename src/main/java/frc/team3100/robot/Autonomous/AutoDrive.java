package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

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

    }

    protected void execute() {
        Robot.drive.driveArcade(speed,rotate);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.drive.driveArcade(0,0);
    }

    protected void interrupted() {

    }
}