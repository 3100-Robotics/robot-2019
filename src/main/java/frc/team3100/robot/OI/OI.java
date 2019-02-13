package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Lifter.*;
import frc.team3100.robot.Limelight.CameraMode;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

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
    public Button cameraModeButton = new JoystickButton(RobotMap.driveControls,RobotMap.leftBumperChannel);
    public Button lifterRotationButton = new JoystickButton(RobotMap.driveControls,RobotMap.yButtonChannel);

    private Button ballRocketBackButton = new JoystickButton(RobotMap.techControls,RobotMap.aButtonChannel);
    private Button ballCargoFrontButton = new JoystickButton(RobotMap.techControls,RobotMap.bButtonChannel);
    private Button ballCargoBackButton = new JoystickButton(RobotMap.techControls,RobotMap.xButtonChannel);
    private Button ballRocketFrontButton = new JoystickButton(RobotMap.techControls,RobotMap.yButtonChannel);

    private Button defenceButton = new JoystickButton(RobotMap.techControls,RobotMap.leftBumperChannel);
    private Button ballPickupBack = new JoystickButton(RobotMap.techControls,RobotMap.rightBumperChannel);



    public OI() {
        shifter.whenPressed(new DriveShift());
        forntControl.whenPressed(new LifterFront(true));
        backControl.whenPressed(new LifterBack(true));
        bothControl.whenPressed(new LifterActuate(true,true));
        safetyButton.whenPressed(new LifterSafety());
        cameraModeButton.whenPressed(new CameraMode());
        lifterRotationButton.whenPressed(new LifterRotate());


        ballRocketBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketBack,Variables.ClawPositions.wristBallScoreRocketBack));
        ballCargoFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoFront,Variables.ClawPositions.armBallScoreCargoFront));
        ballCargoBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoBack,Variables.ClawPositions.wristBallScoreCargoBack));
        ballRocketFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketFront,Variables.ClawPositions.wristBallScoreRocketFront));

        defenceButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armDefence,Variables.ClawPositions.wristDefence));
        ballPickupBack.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupBack,Variables.ClawPositions.wristBallPickupBack));




    }
}
