package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

import static com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;

/*
Pretty much an identical copy of the arm subsystem. Defines all aspects of the wrist and
enables for PID Position control.
 */

public class Wrist extends PIDSubsystem implements Dashboard.DashboardUpdatable {
    private static double kP = SmartDashboard.getNumber("WristP",0);
    private static double kI = SmartDashboard.getNumber("WristI",0);
    private static double kD = SmartDashboard.getNumber("WristD",0);

    public Wrist() {
        super("Wrist",kP,kI,kD);
        getPIDController().setInputRange(0,5);
        getPIDController().setContinuous(true);
    }

    public double returnPIDInput() {
        return RobotMap.wristEncoder.pidGet();
    }

    public void usePIDOutput(double output) {
        this.rotate(output);
    }

    public void rotate(double speed) {
        if(Math.abs(speed) < .2) {
            speed = 0;
            RobotMap.wristBrakeRelease.set(false);
            RobotMap.wristBrakeEngage.set(true);
            Variables.wristLock = true;
        } else {
            if(Variables.wristLock) {
                RobotMap.wristBrakeRelease.set(true);
                RobotMap.wristBrakeEngage.set(false);
                Variables.wristLock = false;
            }
        }
        RobotMap.wristMotor.set(PercentOutput,speed);
    }





    public void initDefaultCommand() {
        setDefaultCommand(new WristMotion());
    }

    public void initSD() {
        LiveWindow.add(getPIDController());
    }

    public void updateSD() {
        LiveWindow.updateValues();
    }

}
