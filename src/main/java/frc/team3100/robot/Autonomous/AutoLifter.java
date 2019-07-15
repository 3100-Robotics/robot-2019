package frc.team3100.robot.Autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Lifter.LifterActuate;
import frc.team3100.robot.Lifter.LifterUltrasonicPauserClose;
import frc.team3100.robot.Lifter.LifterUltrasonicPauserFar;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class AutoLifter extends CommandGroup {

    private Command driving;
    private Command clawMotors;


    public AutoLifter() {
        //addParallel(new AutoClawMotion(Variables.ClawPositions.armClimbMotion,Variables.ClawPositions.wristClimbMotion));
        addSequential(new LifterActuate());
        addSequential(new LifterUltrasonicPauserFar(Variables.Direction.FRONT));
        clawMotors = new AutoClawClimbMotor();
        clawMotors.start();
        driving = new AutoDrive(-.5,0);
        driving.start();
        addSequential(new LifterUltrasonicPauserClose(Variables.Direction.FRONT));
        addParallel(new LifterActuate());
        clawMotors.cancel();
        driving.cancel();
    }

    @Override
    protected void end() {
        if(clawMotors.isRunning()) {
            clawMotors.cancel();
        }
        if(driving.isRunning()) {
            driving.cancel();
        }

    }

    protected boolean isFinished() {
        if(!Robot.oi.safetyButton.get()) {
            return true;
        } else {
            return false;
        }
    }
}