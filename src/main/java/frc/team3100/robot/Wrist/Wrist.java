package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;

public class Wrist extends PIDSubsystem implements Dashboard.DashboardUpdatable {
    private static double kP = SmartDashboard.getNumber("WristP",0);
    private static double kI = SmartDashboard.getNumber("WristI",0);
    private static double kD = SmartDashboard.getNumber("WristD",0);

    public Wrist() {
        super("Wrist",kP,kI,kD);
    }

    public double returnPIDInput() {
        return RobotMap.wristEncoder.get();
    }

    public void usePIDOutput(double output) {

    }

    public void initDefaultCommand() {

    }

    public void initSD() {
        Livewindow.add()
    }

    public void updateSD() {

    }



}
