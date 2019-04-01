package frc.team3100.robot.Limelight;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;


public class LimelightCalculation extends Subsystem implements Dashboard.DashboardUpdatable {
    private double limelightHeight = 6.625;
    private double targetHeight = 28.25;
    private double gyroAngle;
    private double targetAngle;
    private double robotDistance;
    private Trajectory trajectory;
    private TankModifier modifier;
    public Trajectory driveLeft;
    public Trajectory driveRight;
    private double targetX;
    private double targetY;

    public void initDefaultCommand() {

    }

    public double getLimelightX() {
        return Robot.table.getEntry("tx").getDouble(0.0);
    }

    public double getLimelightY() {
        return Robot.table.getEntry("ty").getDouble(0.0);
    }

    public double getDistance() {
        robotDistance = 182 + (42.8 *this.getLimelightY()) + (2.78* Math.pow(this.getLimelightY(),2));
        return robotDistance;
    }

    public double getModifiedGyro() {
        this.getDistance();
        gyroAngle = Robot.ahrs.getAngle();
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

    public double getGyroTarget() {
        double gyroActualVal = this.getModifiedGyro();
        double gyroTargetVal = Math.round(gyroActualVal/45) * 45;
        return gyroTargetVal-gyroActualVal;
    }


    /*public void generateSpline() {


        for (double dt = 0; dt < points; dt++) {
            double t = dt / points;
            double tt = t * t;
            double ttt = tt * t;
            double xt = (targetX * ((-2 * ttt) + (3 * tt))) + (100 * Math.cos(gyroAngle) * (ttt - tt)) + (60 * (ttt - (2 * tt) + t));
            double yt = (targetY * ((-2 * ttt) + (3 * tt))) + (100 * Math.sin(gyroAngle) * (ttt - tt));
            splineCenterPoints[position][0] = xt;
            splineCenterPoints[position][1] = yt;
            position += 1;
        }
        position = 0;


    } */

    public void enableVisionProcessing() {
        Robot.table.getEntry("camMode").setNumber(0);
        Robot.table.getEntry("ledMode").setNumber(0);
    }

    public void disableVisionProcessing() {
        Robot.table.getEntry("camMode").setNumber(1);
        Robot.table.getEntry("ledMode").setNumber(1);
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