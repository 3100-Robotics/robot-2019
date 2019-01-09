package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

import static com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;

/*
This defines all aspects of the drive train-- specifically the shifting to high/low gear and the six mini-CIMs.
Still need to implement PID Control with the magnetic encoders and potentially the NavX.
 */

public class Drive extends Subsystem implements Dashboard.DashboardUpdatable {

    private PIDController leftDrivePod;
    private PIDController rightDrivePod;
    private EncoderPIDSource leftDriveSource;
    private EncoderPIDSource rightDriveSource;
    private MotorPIDOutput leftDriveOutput;
    private MotorPIDOutput rightDriveOutput;


    private double dMoveLimit = 0.1;
    private double limitedMoveLeft = 0;
    private double limitedMoveRight = 0;

    private double leftInputPower = 0;
    private double rightInputPower = 0;


    public Drive() {
        super("Drive");

        leftDriveSource = new EncoderPIDSource(RobotMap.driveLeftEncoder);
        rightDriveSource = new EncoderPIDSource(RobotMap.driveRightEncoder);
        leftDriveOutput = new MotorPIDOutput(RobotMap.leftDriveMotor1);
        rightDriveOutput = new MotorPIDOutput(RobotMap.rightDriveMotor1);

        leftDrivePod = new PIDController(
                SmartDashboard.getNumber("leftDriveP",0),
                SmartDashboard.getNumber("leftDriveI",0),
                SmartDashboard.getNumber("leftDriveD",0),
                leftDriveSource, leftDriveOutput);

        rightDrivePod = new PIDController(
                SmartDashboard.getNumber("rightDriveP",0),
                SmartDashboard.getNumber("rightDriveI",0),
                SmartDashboard.getNumber("rightDriveD",0),
                rightDriveSource, rightDriveOutput);
    }


    public void shiftLow() {
        RobotMap.shiftDriveLow.set(true);
        RobotMap.shiftDriveHigh.set(false);
        Variables.driveTrainState = Variables.DriveTrainStates.low;
    }

    public void shiftHigh() {
        RobotMap.shiftDriveLow.set(false);
        RobotMap.shiftDriveHigh.set(true);
        Variables.driveTrainState = Variables.DriveTrainStates.high;
    }

    public void initDefaultCommand() {setDefaultCommand(new DriveMotion());}




    public void driveTank(double inputMoveLeft, double inputMoveRight) {
        if(Math.abs(inputMoveLeft) < .2) {
            inputMoveLeft = 0;
        }
        if(Math.abs(inputMoveRight) < .2) {
            inputMoveRight = 0;
        }
        if(inputMoveLeft == 0 && inputMoveRight == 0) {
            return;
        }
        if(Variables.driveAuto) {
            Variables.driveAuto = false;
            leftDrivePod.disable();
            rightDrivePod.disable();
        }
        double dMoveLeft = inputMoveLeft - limitedMoveLeft;
        if (dMoveLeft > dMoveLimit) {
            dMoveLeft = dMoveLimit;
        } else if (dMoveLeft < -dMoveLimit) {
            dMoveLeft = -dMoveLimit;
        }

        limitedMoveLeft += dMoveLeft;



        double dMoveRight = inputMoveRight - limitedMoveRight;
        if(dMoveRight > dMoveLimit) {
            dMoveRight = dMoveLimit;
        } else if (dMoveRight < -dMoveLimit) {
            dMoveRight = -dMoveLimit;
        }

        limitedMoveRight += dMoveRight;

        leftInputPower = limitedMoveLeft;
        rightInputPower = limitedMoveRight;
        RobotMap.leftDriveMotor1.set(PercentOutput,limitedMoveLeft);
        RobotMap.rightDriveMotor1.set(PercentOutput,limitedMoveRight);

    }

    public void initSD() {


    }

    public void updateSD() {
        SmartDashboard.putNumber("leftPower",leftInputPower);
        SmartDashboard.putNumber("rightPower",rightInputPower);
        SmartDashboard.putString("DrivetrainGear", Variables.driveTrainState.getGear());
    }
}