package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Lifter.LifterActuate;
import frc.team3100.robot.Lifter.LifterBack;
import frc.team3100.robot.Lifter.LifterFront;
import frc.team3100.robot.Lifter.LifterSafety;
import frc.team3100.robot.Limelight.CameraMode;
import frc.team3100.robot.Mapping.RobotMap;

/*
Interfaces buttons with commands
 */
public class OI {



    public Button shifter = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);
    private Button forntControl = new JoystickButton(RobotMap.driveControls,RobotMap.xButtonChannel);
    private Button backControl = new JoystickButton(RobotMap.driveControls,RobotMap.bButtonChannel);
    private Button bothControl = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);
    public Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    public Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.homeButtonChannel);
    public Button cameraModeButton = new JoystickButton(RobotMap.driveControls,RobotMap.yButtonChannel);
    private Button test1 = new JoystickButton(RobotMap.techControls,RobotMap.aButtonChannel);
    private Button test2 = new JoystickButton(RobotMap.techControls,RobotMap.bButtonChannel);
    private Button test3 = new JoystickButton(RobotMap.techControls,RobotMap.xButtonChannel);
    //private Button test4 = new JoystickButton(RobotMap.techControls,RobotMap.yButtonChannel);





    public OI() {
        shifter.whenPressed(new DriveShift());
        forntControl.whenPressed(new LifterFront(true));
        backControl.whenPressed(new LifterBack(true));
        bothControl.whenPressed(new LifterActuate(true,true));
        safetyButton.whenPressed(new LifterSafety());
        cameraModeButton.whenPressed(new CameraMode());
        test2.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchBack,Variables.ClawPositions.wristHatchBack));
        test3.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupBack,Variables.ClawPositions.wristBallPickupBack));
        test1.whenPressed(new AutoClawMotion(Variables.ClawPositions.armDefence,Variables.ClawPositions.wristDefence));
        //test4.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoFront,Variables.ClawPositions.wristBallScoreCargoFront));



    }
}
