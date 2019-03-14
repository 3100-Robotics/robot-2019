package frc.team3100.robot.Autonomous;

import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Limelight.LimelightCalculation;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motion.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class AutoPathFollower extends Command {
    private BufferedTrajectoryPointStream bufferedStreamLeft = new BufferedTrajectoryPointStream();
    private BufferedTrajectoryPointStream bufferedStreamRight = new BufferedTrajectoryPointStream();



    public AutoPathFollower() {
        super("AutoPathFollower");
        requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
