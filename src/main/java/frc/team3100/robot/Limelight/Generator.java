package frc.team3100.robot.Limelight;

import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;

public class Generator implements Runnable {

    private Trajectory trajectory;
    private TankModifier modifier;
    private double targetX;
    private double targetY;
    private boolean ran = false;

    public void run() {
        Robot.vision.enableVisionProcessing();
        this.reset();
        targetX = Robot.vision.getDistance() * Math.sin(Math.toRadians(Robot.vision.getLimelightX()));
        targetY = Robot.vision.getDistance() * Math.cos(Math.toRadians(Robot.vision.getLimelightX()));

        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
                Trajectory.Config.SAMPLES_FAST, 0.05, 135, 70.0, 60.0);
        Waypoint[] points = new Waypoint[]{
                new Waypoint(400, 400, 0),
                //new Waypoint(400+targetX-8, 400+targetY-3, Pathfinder.d2r(Robot.vision.getGyroTarget()))
                new Waypoint(472,400,Math.toRadians(0))
        };

        trajectory = Pathfinder.generate(points, config);
        modifier = new TankModifier(trajectory).modify(24.7);
        ran = true;
        Robot.vision.disableVisionProcessing();
    }

    public Trajectory getLeftPath() {
        if(ran) {
            return modifier.getLeftTrajectory();
        } else {
            return null;
        }
    }

    public Trajectory getRightPath() {
        if(ran) {
            return modifier.getRightTrajectory();
        } else {
            return null;
        }
    }

    public void reset() {
        trajectory = null;
        modifier = null;
        targetX = 0;
        targetY = 0;
        ran = false;
    }

}
