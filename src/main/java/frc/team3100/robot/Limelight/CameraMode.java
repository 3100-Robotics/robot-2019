package frc.team3100.robot.Limelight;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;


public class CameraMode extends Command {


    public CameraMode() {
        super("CameraMode");

    }

    protected void initialize() {
        Robot.table.getEntry("camMode").setNumber(1);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        if(!Robot.oi.cameraModeButton.get()) {
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        Robot.table.getEntry("camMode").setNumber(0);

    }

    protected void interrupted() {

    }
}
