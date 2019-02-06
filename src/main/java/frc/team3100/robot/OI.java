package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Lifter.LifterActuate;
import frc.team3100.robot.Lifter.LifterBack;
import frc.team3100.robot.Lifter.LifterFront;
import frc.team3100.robot.Lifter.LifterSafety;
import frc.team3100.robot.Mapping.RobotMap;

/*
Interfaces buttons with commands
 */
public class OI {



    private Button shifter = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);
    private Button forntControl = new JoystickButton(RobotMap.driveControls,RobotMap.xButtonChannel);
    private Button backControl = new JoystickButton(RobotMap.driveControls,RobotMap.bButtonChannel);
    private Button bothControl = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);
    private Button climbSafety = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);



    public OI() {
        shifter.whenPressed(new DriveShift());
        forntControl.whenPressed(new LifterFront(true));
        backControl.whenPressed(new LifterBack(true));
        bothControl.whenPressed(new LifterActuate(true,true));
        climbSafety.whenPressed(new LifterSafety());



    }
}
