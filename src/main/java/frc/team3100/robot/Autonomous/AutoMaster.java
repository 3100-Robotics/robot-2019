package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Claw.ClawExtend;
import frc.team3100.robot.Variables;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.modifiers.TankModifier;

/*
This is where we'll put the auto paths.
 */


public class AutoMaster extends CommandGroup {
    private AutoPaths pathData = new AutoPaths();

    private Variables.startPosition left = Variables.startPosition.LEFT;
    private Variables.startPosition right = Variables.startPosition.RIGHT;
    private Variables.startPosition center = Variables.startPosition.CENTER;

    private Variables.preload hatch = Variables.preload.HATCH;
    private Variables.preload cargo = Variables.preload.CARGO;

    private Variables.target cargoFront = Variables.target.CARGOFRONT;
    private Variables.target cargoSide = Variables.target.CARGOSIDE;
    private Variables.target rocket = Variables.target.ROCKET;
    private Variables.target none = Variables.target.NONE;

    private Trajectory trajectory;
    private TankModifier modifier;
    private Trajectory driveLeft;
    private Trajectory driveRight;
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
            Trajectory.Config.SAMPLES_FAST, 0.05, 135, 70.0, 60.0);
   // public AutoMaster(Variables.startPosition startPosition, Variables.preload preload, Variables.target target) {
   //     trajectory = Pathfinder.generate(pathData.pointsFromStart(startPosition,target), config);
   //     modifier = new TankModifier(trajectory).modify(24.7);




   // }



}
