package frc.team3100.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team3100.robot.RobotMap;

import static frc.team3100.robot.RobotMap.leftDriveMotor;
import static frc.team3100.robot.RobotMap.rightDriveMotor;


public class Drive extends Subsystem {

    DifferentialDrive differentialDrive = null;

    double limitSpeed = 1;
    double limitRotate = 1;

    public Drive() {
        super("Drive");

        differentialDrive = new DifferentialDrive(leftDriveMotor, rightDriveMotor);


    }

    public void arcadeDrive(double moveSpeed, double rotateSpeed) {

        moveSpeed = deadband(moveSpeed);
        rotateSpeed = deadband(rotateSpeed);

        limitSpeed = moveSpeed < 0 ? -0.8 : 0.8;
        limitRotate = rotateSpeed < 0 ? -0.8 : 0.8;

        moveSpeed *= limitSpeed * moveSpeed;
        rotateSpeed *= limitRotate * rotateSpeed;

        differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);


    }

    public void tankDrive(double leftSpeed, double rightSpeed){



        leftSpeed = deadband(leftSpeed);
        rightSpeed = deadband(rightSpeed);

        limitSpeed = leftSpeed < 0 ? -0.8 : 0.8;
        limitRotate = rightSpeed < 0 ? -0.8 : 0.8;

        leftSpeed *= limitSpeed *leftSpeed;
        rightSpeed *= limitRotate * rightSpeed;

        differentialDrive.tankDrive(leftSpeed, rightSpeed);

    }

    private double deadband(double input) {
        if(Math.abs(input) < 0.2) {
            return 0;
        } else {
            return input;
        }
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