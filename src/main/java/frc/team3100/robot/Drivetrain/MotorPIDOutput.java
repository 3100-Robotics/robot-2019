package frc.team3100.robot.Drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
Creates an interface between a talon and PID system; currently used within the drive train since there are two
separate PIDs within the same Subsystem.
 */
public class MotorPIDOutput implements PIDOutput {

    private static TalonSRX talon;


    public MotorPIDOutput(TalonSRX talon) {
        this.talon = talon;
    }

    public void pidWrite(double speed) {
        talon.set(ControlMode.PercentOutput,speed);
    }


}
