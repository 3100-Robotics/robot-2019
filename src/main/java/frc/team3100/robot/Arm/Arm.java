package frc.team3100.robot.Arm;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

import static com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;

/*
Subsystem that defines the motion for the arm component of the game piece manipulator.
Defines the breaking action, PID controlled motion, and interfaces with the absolute encoder.
 */


public class Arm extends PIDSubsystem implements Dashboard.DashboardUpdatable {
    private static double kP = SmartDashboard.getNumber("ArmP",0);
    private static double kI = SmartDashboard.getNumber("ArmI",0);
    private static double kD = SmartDashboard.getNumber("ArmD",0);

    public Arm() {
        super("Arm",kP,kI,kD);
        getPIDController().setInputRange(0,5);
        getPIDController().setContinuous(true);
    }

    public double returnPIDInput() {
        return RobotMap.armEncoder.pidGet();
    }

    public void usePIDOutput(double output) {
        this.rotate(output);
    }

    public void rotate(double speed) {
        if(Math.abs(speed) < .2) {
            speed = 0;
            RobotMap.armBrakeRelease.set(false);
            RobotMap.armBrakeEngage.set(true);
            Variables.armLock = true;
        } else {
            if(Variables.armLock) {
                RobotMap.armBrakeRelease.set(true);
                RobotMap.armBrakeEngage.set(false);
                Variables.armLock = false;
            }
        }
        RobotMap.armMotor1.set(PercentOutput,speed);
    }





    public void initDefaultCommand() {
        setDefaultCommand(new ArmMotion());
    }

    public void initSD() {
        LiveWindow.add(getPIDController());
    }

    public void updateSD() {
        LiveWindow.updateValues();
    }

}
