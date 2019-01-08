package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Mapping.XBoxStates;


public class OI {



    public Button shifter = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);


    public OI() {
        shifter.whenPressed(new DriveShift());





    }
}
