package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;

import static com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;


public class Drive extends Subsystem implements Dashboard.DashboardUpdatable {



    private double dMoveLimit = 0.1;
    private double limitedMoveLeft = 0;
    private double limitedMoveRight = 0;

    public Drive() {
        super("Drive");
    }

    public void shiftLow() {
        RobotMap.shiftDriveLow.set(true);
        RobotMap.shiftDriveHigh.set(false);
    }

    public void shiftHigh() {
        RobotMap.shiftDriveLow.set(false);
        RobotMap.shiftDriveHigh.set(true);
    }

    public void initDefaultCommand() {setDefaultCommand(new DriveMotion());}




    public void driveArcade(double inputMoveLeft, double inputMoveRight) {
        SmartDashboard.putNumber("leftPower",inputMoveLeft);

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

        RobotMap.leftDriveMotor1.set(PercentOutput,inputMoveLeft);
        RobotMap.rightDriveMotor1.set(PercentOutput,inputMoveRight);

    }

    public void initSD() {


    }

    public void updateSD() {

    }
}