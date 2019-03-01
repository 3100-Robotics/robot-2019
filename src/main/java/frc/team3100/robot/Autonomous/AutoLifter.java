package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Lifter.LifterActuate;
import frc.team3100.robot.Lifter.LifterUltrasonicPauser;
import frc.team3100.robot.Variables;

public class AutoLifter extends CommandGroup {

    private Command driving = new AutoDrive(.5,0);
    private Command clawMotors = new AutoClawClimbMotor();
    public AutoLifter() {

        addParallel(new AutoClawMotion(Variables.ClawPositions.armClimbMotion,Variables.ClawPositions.wristClimbMotion));
        addSequential(new LifterActuate());
        clawMotors.start();
        driving.start();
        addSequential(new LifterUltrasonicPauser(Variables.Direction.FRONT));
        addParallel(new LifterActuate());
        clawMotors.cancel();
        driving.cancel();
    }

    @Override
    protected void interrupted() {
        if(clawMotors.isRunning()) {
            clawMotors.cancel();
        }
        if(driving.isRunning()) {
            driving.cancel();
        }
    }
}