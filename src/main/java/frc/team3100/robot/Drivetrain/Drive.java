package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.team3100.robot.RobotMap.leftDriveMotor;
import static frc.team3100.robot.RobotMap.rightDriveMotor;


public class Drive extends Subsystem {

    DifferentialDrive differentialDrive = null;

    public Drive() {
        super("Drive");

        differentialDrive = new DifferentialDrive(leftDriveMotor, rightDriveMotor);


    }

    public void arcadeDrive(double moveSpeed, double rotateSpeed, boolean squaredInputs) {

        if (squaredInputs) {
            moveSpeed = Math.copySign(moveSpeed * moveSpeed, moveSpeed);
            rotateSpeed = Math.copySign(rotateSpeed * rotateSpeed, rotateSpeed);
        }

        differentialDrive.arcadeDrive(moveSpeed, rotateSpeed, squaredInputs);

    }

    public void tankDrive(double leftSpeed, double rightSpeed){

        differentialDrive.tankDrive(leftSpeed, rightSpeed);

    }

    protected void initialize() {}

    protected void execute() {}


    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveMotion());
    }

    protected void end() {

    }
}