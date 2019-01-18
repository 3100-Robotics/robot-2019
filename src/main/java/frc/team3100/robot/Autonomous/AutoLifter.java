package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Drivetrain.AutoDrive;
import frc.team3100.robot.Lifter.LifterActuate;
import frc.team3100.robot.Lifter.LifterUltrasonicPauser;
import frc.team3100.robot.Variables;

public class AutoLifter extends CommandGroup {

    private Command driving = new AutoDrive(.5,.5);
    public AutoLifter() {
        addSequential(new LifterActuate(true,true));
        driving.start();
        addSequential(new LifterUltrasonicPauser(Variables.Direction.FRONT));
        addSequential(new LifterActuate(false,true));
        addSequential(new LifterUltrasonicPauser(Variables.Direction.BACK));
        addSequential(new LifterActuate(false,false));
        driving.cancel();

    }

}
