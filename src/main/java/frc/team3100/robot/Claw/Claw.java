package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;

/*
This subsystem defines the claw and the motors used to pickup the cargo.
 */

public class Claw extends Subsystem implements Dashboard.DashboardUpdatable {
    private double motor1Speed = 0;
    private double motor2Speed = 0;

    public Claw() {
        super("Claw");
    }


    public void wheels(double speed1, double speed2) {
        RobotMap.clawMotor1.set(speed1);
        RobotMap.clawMotor2.set(speed2);
        motor1Speed = speed1;
        motor2Speed = speed2;
    }

    public void extend(boolean extend) {
        RobotMap.clawHatchRelease.set(extend);
    }



    public void initDefaultCommand() {
        setDefaultCommand(new ClawRotate());
    }

    public void initSD() {
    }

    public void updateSD() {
        SmartDashboard.putNumber("Claw Motor 1 Speed",motor1Speed);
        SmartDashboard.putNumber("Claw Motor 2 Speed",motor2Speed);
    }


}
