package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Lifter.LifterActuate;
import frc.team3100.robot.Lifter.LifterUltrasonicPauser;
import frc.team3100.robot.Variables;

public class AutoLifter extends CommandGroup {

    private Command driving = new AutoDrive(.5,0);
    public AutoLifter() {
        /*
        addParallel(new AutoClawMotion(Variables.ClawPositions.armClimbMotion,Variables.ClawPositions.wristClimbMotion));
        addSequential(new LifterActuate(true));
        addSequential(new );
        */
    }

}