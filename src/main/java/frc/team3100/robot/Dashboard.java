package frc.team3100.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;

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
		for (DashboardUpdatable subsystem : subsystems) {
			subsystem.initSD();
		}
		
		SmartDashboard.putData("Toggle Compressor", new ToggleCompressor());

		SmartDashboard.putNumber("LimelightX", Robot.table.getEntry("tx").getDouble(0.0));
		SmartDashboard.putNumber("LimelightY", Robot.table.getEntry("ty").getDouble(0.0));
		SmartDashboard.putNumber("LimelightArea", Robot.table.getEntry("ta").getDouble(0.0));

		SmartDashboard.putNumber("Distance",Math.log(Robot.table.getEntry("ta").getDouble(0.0)/22.7968301) / Math.log(0.9278672366));

		updateTimer.start();
	}





	public static void updateDashboard() {
		if (updateTimer.hasPeriodPassed(0.2)) {
		
			for (DashboardUpdatable subsystem : subsystems) {
				subsystem.updateSD();
			}
			SmartDashboard.putBoolean("autoVal",Robot.autoVal);
			SmartDashboard.putNumber("Dashboard Update Counts", updateCounts++);

			SmartDashboard.putNumber("LimelightX", Robot.table.getEntry("tx").getDouble(0.0));
			SmartDashboard.putNumber("LimelightY", Robot.table.getEntry("ty").getDouble(0.0));
			SmartDashboard.putNumber("LimelightArea", Robot.table.getEntry("ta").getDouble(0.0));

			SmartDashboard.putNumber("Distance",Math.log(Robot.table.getEntry("ta").getDouble(0.0)/22.7968301) / Math.log(0.9278672366));
		}
	}
	
	public interface DashboardUpdatable {
		public void initSD();
		public void updateSD();
	}
}
