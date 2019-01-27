package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Mapping.RobotMap;

/*
Interfaces buttons with commands
 */
public class OI {



    private Button shifter = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);
    private Button test1 = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton1Channel);
    private Button test2 = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton2Channel);
    private Button test3 = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton3Channel);



    public OI() {
        shifter.whenPressed(new DriveShift());





    }
}
