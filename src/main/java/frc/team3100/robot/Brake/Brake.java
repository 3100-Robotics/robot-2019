package frc.team3100.robot.Brake;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;


public class Brake extends Subsystem implements Dashboard.DashboardUpdatable {
    private double motorSpeed = 0;

    public Brake() {
        super("Brake");
    }


    public void extend() {
        RobotMap.armBrakeEngage.set(false);
    }

    public void retract() {
        RobotMap.armBrakeEngage.set(true);
    }



    public void initDefaultCommand() {
        setDefaultCommand(new BrakeArmActuation());
    }

    public void initSD() {
    }

    public void updateSD() {
        SmartDashboard.putNumber("Claw Speed",motorSpeed);
    }


}
