package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

/*
    This needs work. Must implement driving-straight PID and driving set distances
     */

public class AutoDrive extends Command {
    private double speedLeft;
    private double speedRight;

    public AutoDrive(double speedLeft, double speedRight) {
        super("DriveMotion");
        requires(Robot.drive);
        this.speedLeft = speedLeft;
        this.speedRight = speedRight;
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.drive.driveTank(speedLeft,speedRight);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.drive.driveTank(0,0);
    }

    protected void interrupted() {

    }
}
