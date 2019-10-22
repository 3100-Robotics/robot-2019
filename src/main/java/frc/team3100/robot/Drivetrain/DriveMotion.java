package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;


public class DriveMotion extends Command {
    public DriveMotion() {
        super("DriveMotion");
        requires(Robot.drive);

    }


    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

        double moveSpeed = -Robot.oi.driverController.getRawAxis(RobotMap.moveAxis);
        double rotateSpeed = Robot.oi.driverController.getRawAxis(RobotMap.rotateAxis);
        boolean squaredInput = true;

        Robot.drive.arcadeDrive(moveSpeed, rotateSpeed, squaredInput);

//        double leftSpeed = -Robot.oi.driverController.getRawAxis(RobotMap.moveAxis);
//        double rightSpeed = Robot.oi.driverController.getRawAxis(RobotMap.rotateAxis);
//        Robot.drive.tankDrive(leftSpeed, rightSpeed);


        //Robot.drive.arcadeDrive(-RobotMap.driveControls.getLeftStickY(), -RobotMap.driveControls.getRightStickY());
        //Robot.drive.driveTank(-RobotMap.driveControls.getLeftStickY(), -RobotMap.driveControls.getRightStickY());

    }


    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        super.interrupted();
    }
}


