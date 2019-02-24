package frc.team3100.robot.Lifter;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.OI.Dashboard;
import frc.team3100.robot.Mapping.RobotMap;

/*
This subsystem defines the claw and the motors used to pickup the cargo.
 */

public class Lifter extends Subsystem implements Dashboard.DashboardUpdatable {
    private static double motorSpeed = 0;

    public Lifter() {
        super("Lifter");
    }


    public void extend(boolean extend) {
        // input true/false to extend/retract the piston
        RobotMap.lifterFrontExtend.set(extend);
    }






    public void initDefaultCommand() {
    }

    public void initSD() {

    }

    public void updateSD() {

    }


}