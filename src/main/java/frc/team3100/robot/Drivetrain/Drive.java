package frc.team3100.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FollowerType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This defines all aspects of the drive train-- specifically the shifting to high/low gear and the six mini-CIMs.
Still need to implement PID Control with the magnetic encoders and potentially the NavX.
 */

public class Drive extends PIDSubsystem implements Dashboard.DashboardUpdatable {

    private double dSpeedLimit = 0.08;
    private double dRotateLimit = 0.08;
    private double limitedSpeed = 0;
    private double limitedRotate = 0;
    private double scaleRotate = 1;
    private double scaleSpeed = 1;
    private boolean ran = false;
    private double targetAngle = 0;

    public Drive() {
        super("Drive",.04,0,0);
        setOutputRange(-1,1);
        setSetpoint(0);
    }


    public void initDefaultCommand() {setDefaultCommand(new DriveMotion());}

    public double returnPIDInput() {
        return Robot.vision.getLimelightX();
    }

    public void usePIDOutput(double output) {
        System.out.println(output);
        this.driveArcade(RobotMap.driveControls.getLeftStickY(),-output);
    }




    public void driveArcade(double inputSpeed, double inputRotate) {
        inputSpeed = deadband(inputSpeed);
        inputRotate = deadband(inputRotate);



        scaleSpeed = inputSpeed < 0 ? -1 : 1;
        scaleRotate = inputRotate < 0 ? -1 : 1;

        inputSpeed *= inputSpeed * scaleSpeed;
        inputRotate *= inputRotate * scaleRotate;


        double dSpeed = inputSpeed - limitedSpeed;
        if (dSpeed > dSpeedLimit) {
            dSpeed = dSpeedLimit;
        } else if (dSpeed < -dSpeedLimit) {
            dSpeed = -dSpeedLimit;
        }
        limitedSpeed += dSpeed;

        double dRotate = inputRotate - limitedRotate;
        if (dRotate > dRotateLimit) {
            dRotate = dRotateLimit;
        } else if (dRotate < -dRotateLimit) {
            dRotate = -dRotateLimit;
        }

        limitedRotate += dRotate;

        if(inputRotate != 0) {

            RobotMap.leftDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.ArbitraryFeedForward, -limitedRotate);
            RobotMap.rightDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.ArbitraryFeedForward, +limitedRotate);
            ran = false;

        } else {

            targetAngle = RobotMap.rightDriveMotor1.getSensorCollection().getPulseWidthVelocity() - RobotMap.leftDriveMotor1.getSensorCollection().getPulseWidthVelocity();

            RobotMap.rightDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.AuxPID, targetAngle);
            RobotMap.leftDriveMotor1.follow(RobotMap.rightDriveMotor1, FollowerType.AuxOutput1);
            ran = true;


        }
    }

    private double deadband(double input) {
        if(Math.abs(input) < Variables.joystickError) {
            return 0;
        } else {
            return input;
        }
    }

    public void stop() {
        RobotMap.leftDriveMotor1.set(ControlMode.PercentOutput,0);
        RobotMap.rightDriveMotor1.set(ControlMode.PercentOutput,0);

    }

    public void initSD() {

    }

    public void updateSD() {
        SmartDashboard.putNumber("Drive Speed",limitedSpeed);
        SmartDashboard.putNumber("Drive Rotate",limitedRotate);
        SmartDashboard.putNumber("Drive Left Sensor",RobotMap.leftDriveMotor1.getSensorCollection().getQuadraturePosition());
        SmartDashboard.putNumber("Drive Right Sensor",RobotMap.rightDriveMotor1.getSensorCollection().getQuadraturePosition());

    }
}