package frc.team3100.robot.OI;

import com.sun.org.apache.xpath.internal.operations.Variable;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Claw.ClawExtend;
import frc.team3100.robot.Lifter.*;
import frc.team3100.robot.Limelight.CameraMode;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Interfaces buttons with commands
 */
public class OI {



    public Button cameraModeButton = new JoystickButton(RobotMap.driveControls,RobotMap.yButtonChannel);
    private Button hatchReleaseButton = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);

    public Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    public Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.backButtonChannel);


    private Button ballPickupPlayerBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton12Channel);
    private Button ballPickupPlayerFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton7Channel);
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


    private Button hatchPlayerCollectButton = new JoystickButton(RobotMap.techControls,RobotMap.aButtonChannel);



    public OI() {
        cameraModeButton.whenPressed(new CameraMode());
        hatchReleaseButton.whenPressed(new ClawExtend());


        ballRocketBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketBack,Variables.ClawPositions.wristBallScoreRocketBack));
        ballCargoFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoFront,Variables.ClawPositions.wristBallScoreCargoFront));
        ballCargoBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoBack,Variables.ClawPositions.wristBallScoreCargoBack));
        ballRocketFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketFront,Variables.ClawPositions.wristBallScoreRocketFront));
        ballRocket2BackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRockketlv2, Variables.ClawPositions.wristBallScoreRockketlv2));

        ballPickupBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupBack,Variables.ClawPositions.wristBallPickupBack));
        ballPickupFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupFront,Variables.ClawPositions.wristBallPickupFront));
        ballPickupPlayerBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupPlayerBack,Variables.ClawPositions.wristBallPickupPlayerBack));
        ballPickupPlayerFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupPlayerFront,Variables.ClawPositions.wristBallPickupPlayerFront));

        defenceButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armDefence,Variables.ClawPositions.wristDefence));

        hatchGroundPrepButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchGroundPrep,Variables.ClawPositions.wristHatchGroundPrep));
        hatchGroundButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchGround,Variables.ClawPositions.wristHatchGround));
        hatchScoreFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchFront,Variables.ClawPositions.wristHatchFront));
        hatchScoreBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchBack,Variables.ClawPositions.wristHatchBack));

        hatchPlayerCollectButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchPlayerGrab,Variables.ClawPositions.wristHatchPlayerGrab));
    }
}
