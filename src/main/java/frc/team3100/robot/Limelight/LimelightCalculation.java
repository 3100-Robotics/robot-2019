package frc.team3100.robot.Limelight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;



public class LimelightCalculation implements Dashboard.DashboardUpdatable {
    private double limelightHeight = 4;
    private double targetHeight = 28.25;
    private double limelightAngle = 28;
    private double gyroAngle;
    private double robotDistance;
    private double targetX;
    private double targetY;
    private int points = 100;
    private double[] splineCenterPoints = new double[points];

    public double getLimelightX() {
        return Robot.table.getEntry("tx").getDouble(0.0);
    }

    public double getLimelightY() {
        return Robot.table.getEntry("ty").getDouble(0.0);
    }

    public double getDistance() {
        Robot.table.getEntry("camMode").setNumber(1);
        robotDistance = (targetHeight - limelightHeight) / Math.tan(Math.toRadians(this.getLimelightY() + limelightAngle));
        return robotDistance;
    }

    public double getModifiedGyro() {
        this.getDistance();
        gyroAngle = RobotMap.gyro.getAngle();
        while (Math.abs(gyroAngle) >= 360) {
            if (gyroAngle > 360) {
                gyroAngle -= 360;
            } else {
                gyroAngle += 360;
            }
        }
        if (gyroAngle < 0) {
            gyroAngle += 360;
        }
        return gyroAngle;
    }


    public void generateSpline() {
        targetX = robotDistance * Math.cos(getLimelightX());
        targetY = robotDistance * -1 * Math.sin(getLimelightX());
        for(double dt = 0; dt < points; dt ++) {
            double t = dt / points;
            double tt = t * t;
            double ttt = tt * t;
            double xt = (targetX * ((-2 * ttt) + (3 * tt))) + (100 * Math.cos(gyroAngle) * (ttt - tt)) + (60 * (ttt - (2 * tt) + t));
            double yt = (targetY * ((-2 * ttt) + (3 * tt))) + (100 * Math.sin(gyroAngle) * (ttt - tt));
        }
    }

    public void initSD() {

    }

    public void updateSD() {
        SmartDashboard.putNumber("LimelightDistance",this.getDistance());
        SmartDashboard.putNumber("LimelightX", Robot.table.getEntry("tx").getDouble(0.0));
        SmartDashboard.putNumber("LimelightY", Robot.table.getEntry("ty").getDouble(0.0));
        SmartDashboard.putNumber("LimelightArea", Robot.table.getEntry("ta").getDouble(0.0));
    }

}