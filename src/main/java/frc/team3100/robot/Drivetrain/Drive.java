package frc.team3100.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FollowerType;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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

    private double dSpeedLimit = 0.06;
    private double dRotateLimit = 0.06;
    private double limitedSpeed = 0;
    private double limitedRotate = 0;
    private double scaleRotate = 1;
    private double scaleSpeed = 1;
    private double speedOutput = 0;
    private double rotateOutput = 0;
    private boolean _firstCall = true;
    private boolean ran = false;


    public Drive() {
        super("Drive");
    }


    public void shiftLow() {
        RobotMap.shiftDriveLow.set(true);
        Variables.driveTrainState = Variables.DriveTrainStates.low;
    }

    public void shiftHigh() {
        RobotMap.shiftDriveLow.set(false);
        Variables.driveTrainState = Variables.DriveTrainStates.high;
    }

    public void initDefaultCommand() {setDefaultCommand(new DriveMotion());}




    public void driveArcade(double inputSpeed, double inputRotate) {
        inputSpeed = deadband(inputSpeed);
        inputRotate = deadband(inputRotate);

        scaleSpeed = inputSpeed < 1 ? -1:1;
        scaleRotate = inputRotate < 1 ? -1:1;

        inputSpeed = inputSpeed * inputSpeed * scaleSpeed;
        inputRotate = inputRotate * inputRotate * scaleRotate;


        double dSpeed = inputSpeed - limitedSpeed;
        if (dSpeed > dSpeedLimit) {
            dSpeed = dSpeedLimit;
        } else if (dSpeed < -dSpeedLimit) {
            dSpeed = -dSpeedLimit;
        }

        limitedSpeed += dSpeed;

        if(inputRotate != 0) {
            double dRotate = inputRotate - limitedRotate;
            if (dRotate > dRotateLimit) {
                dRotate = dRotateLimit;
            } else if (dRotate < -dRotateLimit) {
                dRotate = -dRotateLimit;
            }

            limitedRotate += dRotate;

            RobotMap.leftDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.ArbitraryFeedForward, -limitedRotate);
            RobotMap.rightDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.ArbitraryFeedForward, +limitedRotate);
            ran = true;
        } else {
            /*
            if (_firstCall) {
                _targetAngle = RobotMap.rightDriveMotor1.getSelectedSensorPosition(1);

                // Determine which slot affects which PID
                RobotMap.rightDriveMotor1.selectProfileSlot(Variables.kSlot_Turning, Variables.PID_TURN);
            }

            // Configured for percentOutput with Auxiliary PID on Quadrature Encoders' Difference
            RobotMap.rightDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.AuxPID, _targetAngle);
            RobotMap.leftDriveMotor1.follow(RobotMap.rightDriveMotor1, FollowerType.AuxOutput1);
            _firstCall = false;
            */
            double dRotate = inputRotate - limitedRotate;
            if (dRotate > dRotateLimit) {
                dRotate = dRotateLimit;
            } else if (dRotate < -dRotateLimit) {
                dRotate = -dRotateLimit;
            }

            limitedRotate += dRotate;

            RobotMap.leftDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.ArbitraryFeedForward, -limitedRotate);
            RobotMap.rightDriveMotor1.set(ControlMode.PercentOutput, limitedSpeed, DemandType.ArbitraryFeedForward, +limitedRotate);
            ran = true;
        }

    }

    private double deadband(double input) {
        if(Math.abs(input) < .2) {
            return 0;
        } else {
            return input;
        }
    }

    public void initSD() {

    }

    public void updateSD() {
        SmartDashboard.putNumber("speedOutput",limitedSpeed);
        SmartDashboard.putNumber("rotateOutput",limitedRotate);
        SmartDashboard.putString("DrivetrainGear", Variables.driveTrainState.getGear());
    }
}