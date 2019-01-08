package frc.team3100.robot.Wrist;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;

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
