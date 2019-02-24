package frc.team3100.robot.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
The command listens for a change in the technician controller's right joystick and
overrides the autonomous control of the claw arm.


MAX V / 100 ms ==
 */

public class ArmMotion extends Command {
    private double speed;

    public ArmMotion() {
        super("ArmMotion");
        requires(Robot.arm);
    }

    protected void initialize() {

    }

    protected void execute() {
        // Pulls joystick input and applies it to arm speed for manual control.

        speed = RobotMap.techControls.getLeftStickY();
        if(Math.abs(speed) < .2 && !Variables.armAuto) {
            // Adds anti-gravity when not given controller input
            Robot.arm.manualRotation(.21 * (RobotMap.armMotor1.getSensorCollection().getAnalogIn() > 512 ? -1:1));
        } else {
            Robot.arm.manualRotation(speed);
        }
        
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
        Robot.arm.stop();
    }
}

