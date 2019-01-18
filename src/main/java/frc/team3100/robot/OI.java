package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Autonomous.AutoLifter;
import frc.team3100.robot.Mapping.RobotMap;

/*
Interfaces buttons with commands
 */
public class OI {



    private Button shifter = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);
    private Button lifter = new JoystickButton(RobotMap.driveControls,RobotMap.leftBumperChannel);
    private Button test1 = new JoystickButton(RobotMap.driveControls,RobotMap.bButtonChannel);
    private Button test2 = new JoystickButton(RobotMap.driveControls,RobotMap.xButtonChannel);
    private Button test3 = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);



    public OI() {
        shifter.whenPressed(new DriveShift());
        test1.whenPressed(new AutoClawMotion(Variables.ClawPositions.armFHigh));
        test2.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBHigh));
        lifter.whenPressed(new AutoLifter());
        test3.whenPressed(new Reset());





    }
}
