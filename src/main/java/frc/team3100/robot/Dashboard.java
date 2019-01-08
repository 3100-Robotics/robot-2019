package frc.team3100.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		for (DashboardUpdatable subsystem : subsystems) {
			subsystem.initSD();
		}
		
		SmartDashboard.putData("Toggle Compressor", new ToggleCompressor());
		
		updateTimer.start();
	}





	public static void updateDashboard() {
		if (updateTimer.hasPeriodPassed(0.25)) {
		
			for (DashboardUpdatable subsystem : subsystems) {
				subsystem.updateSD();
			}
			SmartDashboard.putBoolean("autoVal",Robot.autoVal);
			SmartDashboard.putNumber("Dashboard Update Counts", updateCounts++);
		}
	}
	
	public interface DashboardUpdatable {
		public void initSD();
		public void updateSD();
	}
}
