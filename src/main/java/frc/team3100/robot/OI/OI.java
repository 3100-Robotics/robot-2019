package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Claw.ClawExtend;
import frc.team3100.robot.Drivetrain.DriveShift;
import frc.team3100.robot.Lifter.*;
import frc.team3100.robot.Limelight.CameraMode;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Interfaces buttons with commands
 */
public class OI {



    public Button shifter = new JoystickButton(RobotMap.driveControls,RobotMap.leftBumperChannel);
    private Button frontControl = new JoystickButton(RobotMap.driveControls,RobotMap.xButtonChannel);
    private Button backControl = new JoystickButton(RobotMap.driveControls,RobotMap.bButtonChannel);
    private Button bothControl = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);
    public Button cameraModeButton = new JoystickButton(RobotMap.driveControls,RobotMap.yButtonChannel);
    public Button lifterRotationButton = new JoystickButton(RobotMap.driveControls,RobotMap.yButtonChannel);
    private Button hatchReleaseButton = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);

    public Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    public Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.backButtonChannel);


    private Button ballPickupPlayerBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton12Channel);
    private Button ballPickipPlayerFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton7Channel);
    private Button ballPickupBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton14Channel);
    private Button ballPickupFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton5Channel);

    private Button ballRocketBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton11Channel);
    private Button ballCargoFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton6Channel);
    private Button ballCargoBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton13Channel);
    private Button ballRocketFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton8Channel);
    private Button ballRocket2BackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton10Channel);

    private Button defenceButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton9Channel);

    private Button hatchGroundPrepButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton3Channel);
    private Button hatchGroundButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton2Channel);
    private Button hatchScoreFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton1Channel);
    private Button hatchScoreBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton4Channel);




    public OI() {
        shifter.whenPressed(new DriveShift());
        frontControl.whenPressed(new LifterFront(true));
        backControl.whenPressed(new LifterBack(true));
        bothControl.whenPressed(new LifterActuate(true,true));
        cameraModeButton.whenPressed(new CameraMode());
        lifterRotationButton.whenPressed(new LifterRotate());
        hatchReleaseButton.whenPressed(new ClawExtend());


        ballRocketBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketBack,Variables.ClawPositions.wristBallScoreRocketBack));
        ballCargoFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoFront,Variables.ClawPositions.wristBallScoreCargoFront));
        ballCargoBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoBack,Variables.ClawPositions.wristBallScoreCargoBack));
        ballRocketFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketFront,Variables.ClawPositions.wristBallScoreRocketFront));

        ballPickupBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupBack,Variables.ClawPositions.wristBallPickupBack));
        ballPickupFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupFront,Variables.ClawPositions.wristBallPickupFront));
        ballPickupPlayerBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupPlayerBack,Variables.ClawPositions.wristBallPickupPlayerBack));
        ballPickipPlayerFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupPlayerFront,Variables.ClawPositions.wristBallPickupPlayerFront));

        defenceButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armDefence,Variables.ClawPositions.wristDefence));

        hatchGroundPrepButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchGroundPrep,Variables.ClawPositions.wristHatchGroundPrep));
        hatchGroundButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchGround,Variables.ClawPositions.wristHatchGround));
        hatchScoreFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchFront,Variables.ClawPositions.wristHatchFront));
        hatchScoreBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchBack,Variables.ClawPositions.wristHatchBack));
    }
}
