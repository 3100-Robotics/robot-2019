package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Limelight.GenerateSpline;
import frc.team3100.robot.Robot;

public class AutoScore extends CommandGroup {

    public AutoScore() {
        Robot.vision.enableVisionProcessing();
        addSequential(new GenerateSpline());
        addSequential(new AutoPathFollower(Robot.vision.driveLeft,Robot.vision.driveRight));
        Robot.vision.disableVisionProcessing();
    }


    protected void end() {
        Robot.vision.disableVisionProcessing();
    }
}
