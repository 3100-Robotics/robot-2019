package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class AutoPathFollower extends Command {
        private Trajectory leftPath;
        private Trajectory rightPath;
        private EncoderFollower followerLeft;
        private EncoderFollower followerRight;
        private int time = 0;


    public AutoPathFollower(Trajectory leftPath, Trajectory rightPath) {
        super("AutoPathFollower");
        requires(Robot.drive);
        this.leftPath = leftPath;
        this.rightPath = rightPath;
    }

    protected void initialize() {

        followerLeft = new EncoderFollower();
        followerLeft.configurePIDVA(.6,0,0,1/132,0);
        followerLeft.configureEncoder(RobotMap.leftDriveMotor1.getSensorCollection().getQuadraturePosition(),
                4096,8);
        followerLeft.setTrajectory(leftPath);

        followerRight = new EncoderFollower();
        followerRight.configurePIDVA(.6,0,0,1/132,0);
        followerRight.configureEncoder(RobotMap.rightDriveMotor1.getSensorCollection().getQuadraturePosition(),
                4096,8);
        followerRight.setTrajectory(rightPath);


    }

    protected void execute() {
        Robot.drive.driveArcade(followerLeft.calculate(RobotMap.leftDriveMotor1.getSensorCollection().getQuadraturePosition()),
                RobotMap.rightDriveMotor1.getSensorCollection().getQuadraturePosition());
        time += 1;
    }

    protected boolean isFinished() {
        if((followerLeft.isFinished() &&
                followerRight.isFinished()) ||
                Math.abs(RobotMap.driveControls.getLeftStickY()) > .2 ||
                Math.abs(RobotMap.driveControls.getRightStickX()) > .2 ||
                (rightPath.length() - time < -10)) {
            return true;
        } else {
            return false;
        }
    }

    protected void end() {

    }

    protected void interrupted() {
        Robot.drive.stop();
    }
}
