package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

public class Claw extends Subsystem implements Dashboard.DashboardUpdatable {
    private static double motorSpeed = 0;

    public Claw() {
        super("Claw");
    }


    public void wheels(double speed) {
        RobotMap.clawMotor.set(speed);
        motorSpeed = speed;
    }



    public void initDefaultCommand() {
        setDefaultCommand(new ClawRotate());
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
