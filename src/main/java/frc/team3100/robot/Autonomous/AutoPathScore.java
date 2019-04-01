package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.DistanceFollower;

public class AutoPathScore extends Command {
        private Trajectory leftPath = null;
        private Trajectory rightPath = null;
        private DistanceFollower followerLeft;
        private DistanceFollower followerRight;
        private int time = 0;
        private double initLeft;
        private double initRight;
        private boolean ran = false;
        private boolean config = false;
        private double distancePerTick = 8.0 * 3.14159265 / 4098.0;

    public AutoPathScore() {
        super("AutoPathFollower");
        requires(Robot.drive);
    }

    protected void initialize() {
        SmartDashboard.putNumber("a",1.0);
        Robot.vision.enableVisionProcessing();
        Robot.gen.run();
        RobotMap.leftDriveMotor1.setSelectedSensorPosition(0);
        RobotMap.rightDriveMotor1.setSelectedSensorPosition(0);

    }

    protected void execute() {
        if(leftPath == null || rightPath == null) {
            leftPath = Robot.gen.getLeftPath();
            rightPath = Robot.gen.getRightPath();
        } else {
            ran = true;
        }

        if(ran && !config) {
            SmartDashboard.putString("B","Trajectory Length: " + leftPath.length());
            followerLeft = new DistanceFollower(leftPath);
            followerLeft.configurePIDVA(0.007,0,0.0001,1/132.0,0);

            followerRight = new DistanceFollower(rightPath);
            followerRight.configurePIDVA(0.007,0,0.0001,1/132.0,0);

            initLeft = RobotMap.leftDriveMotor1.getSelectedSensorPosition();
            initRight = RobotMap.rightDriveMotor1.getSelectedSensorPosition();
            SmartDashboard.putString("AA","Config Complete. Beginning Driving.");
            config = true;
        }


        if(ran && config) {
            Robot.drive.driveTank(followerLeft.calculate((RobotMap.leftDriveMotor1.getSelectedSensorPosition()-initLeft)*distancePerTick*-1),
                    followerRight.calculate((RobotMap.rightDriveMotor1.getSelectedSensorPosition()-initRight)*distancePerTick*-1));
            time += 1;

        }

    }

    protected boolean isFinished() {
        if(Math.abs(RobotMap.driveControls.getLeftStickY()) > .2 ||
                Math.abs(RobotMap.driveControls.getRightStickX()) > .2) {
            System.out.println("DRIVER OVERRIDE");

            return true;
        } else {
            if (config) {
                if (((rightPath.length()*2) - time < -200)) {
                    SmartDashboard.putNumber("b",1.0);
                    System.out.println("Finished Path");
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    protected void end() {
        Robot.vision.disableVisionProcessing();
    }

    protected void interrupted() {
        Robot.drive.stop();
    }
}
