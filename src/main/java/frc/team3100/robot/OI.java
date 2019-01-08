package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Mapping.XBoxStates;


public class OI {

    private XBoxStates driveControls = RobotMap.driveControls;


    public Button shifter = new JoystickButton(driveControls,RobotMap.aButtonChannel);


    public OI() {
        shifter.whenPressed(new DriveShift());




    }
}
