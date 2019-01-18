package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
This subsystem defines the claw and the motors used to pickup the cargo.
 */

public class Lifter extends Subsystem implements Dashboard.DashboardUpdatable {
    private static double motorSpeed = 0;

    public Lifter() {
        super("Lifter");
    }


    public void frontToggle(boolean extend) {

    }

    public void backToggle(boolean extend) {

    }



    public void initDefaultCommand() {
    }

    public void initSD() {
        SmartDashboard.putNumber("ClawMotorSpeed",motorSpeed);
        SmartDashboard.putBoolean("ClawOpen", Variables.clawOpenState);
    }

    public void updateSD() {
        SmartDashboard.putNumber("ClawMotorSpeed",motorSpeed);
        SmartDashboard.putBoolean("ClawOpen", Variables.clawOpenState);
    }


}
