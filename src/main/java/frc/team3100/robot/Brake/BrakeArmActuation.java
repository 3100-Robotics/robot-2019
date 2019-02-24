package frc.team3100.robot.Brake;

import com.sun.org.apache.xpath.internal.operations.Variable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;



public class BrakeArmActuation extends Command {


    public BrakeArmActuation() {
        super("BrakeArmActuation");
        requires(Robot.brake);
    }

    protected void initialize() {

    }

    protected void execute() {
        if(Math.abs(RobotMap.armMotor1.getOutputCurrent()) > .3 && !Variables.armAuto) {
            Robot.brake.retract();
        } else {
            Robot.brake.extend();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}

