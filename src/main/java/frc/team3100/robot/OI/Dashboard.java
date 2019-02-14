package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for updating the smart dashboard periodically during the match.
 *
 */
public class Dashboard {
	
	private static List<DashboardUpdatable> subsystems = new ArrayList<DashboardUpdatable>();
	private static int updateCounts = 0;

	private static Timer updateTimer = new Timer();
	
	public static void clearDashboard() {
		for(String key : SmartDashboard.getKeys()) {
			SmartDashboard.delete(key);
		}
	}
	
	public static void initDashboard() {

        subsystems.add(Robot.drive);
        subsystems.add(Robot.arm);
        subsystems.add(Robot.claw);
        subsystems.add(Robot.wrist);
        subsystems.add(Robot.brake);
        subsystems.add(Robot.vision);
		for (DashboardUpdatable subsystem : subsystems) {
			subsystem.initSD();
		}
		updateTimer.start();
	}





	public static void updateDashboard() {
		if (updateTimer.hasPeriodPassed(0.2)) {
		
			for (DashboardUpdatable subsystem : subsystems) {
				subsystem.updateSD();
			}


			SmartDashboard.putNumber("POVVAL",RobotMap.techControls.getPOV());
			SmartDashboard.putBoolean("autoVal",Robot.autoVal);
			SmartDashboard.putNumber("Dashboard Update Counts", updateCounts++);
		}
	}
	
	public interface DashboardUpdatable {
		void initSD();
		void updateSD();
	}
}
