package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Autonomous.SensorReset;
import frc.team3100.robot.Claw.ClawExtend;
import frc.team3100.robot.Lifter.*;
import frc.team3100.robot.Limelight.CameraScore;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Interfaces buttons with commands
 */
public class OI {



    public Button cameraModeButton = new JoystickButton(RobotMap.driveControls,RobotMap.yButtonChannel);
    private Button hatchReleaseButton = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);
    private Button climbingPrep = new JoystickButton(RobotMap.techControls,RobotMap.xButtonChannel);
    public Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    public Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.backButtonChannel);





    private Button lifterActuateButton = new JoystickButton(RobotMap.techControls,RobotMap.aButtonChannel);
    private Button hatchPlayerCollectButton = new JoystickButton(RobotMap.techControls,RobotMap.yButtonChannel);
    private Button sensorResetButton = new JoystickButton(RobotMap.techControls,RobotMap.bButtonChannel);






    private Button ballPickupPlayerBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton8Channel);
    private Button ballPickupPlayerFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton15Channel);
    private Button ballPickupBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton7Channel);
    private Button ballPickupFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton16Channel);

    private Button ballRocketBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton10Channel);
    private Button ballCargoFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton14Channel);
    private Button ballCargoBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton9Channel);
    private Button ballRocketFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton13Channel);
    private Button ballRocket2BackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton11Channel);

    private Button defenceButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton12Channel);

    private Button hatchScoreFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton5Channel);
    private Button hatchScoreBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton2Channel);





    public OI() {
        cameraModeButton.whenPressed(new CameraScore());
        hatchReleaseButton.whenPressed(new ClawExtend());
        lifterActuateButton.whenPressed(new LifterActuate());
        sensorResetButton.whenPressed(new SensorReset());
        safetyButton.whenPressed(new LifterSafety());

        climbingPrep.whenPressed(new AutoClawMotion(Variables.ClawPositions.armClimbPrep,Variables.ClawPositions.wristClimbPrep));

        ballRocketBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketBack,Variables.ClawPositions.wristBallScoreRocketBack));
        ballCargoFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoFront,Variables.ClawPositions.wristBallScoreCargoFront));
        ballCargoBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoBack,Variables.ClawPositions.wristBallScoreCargoBack));
        ballRocketFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketFront,Variables.ClawPositions.wristBallScoreRocketFront));
        ballRocket2BackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketlv2, Variables.ClawPositions.wristBallScoreRocketlv2));

        ballPickupBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupBack,Variables.ClawPositions.wristBallPickupBack));
        ballPickupFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupFront,Variables.ClawPositions.wristBallPickupFront));
        ballPickupPlayerBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupPlayerBack,Variables.ClawPositions.wristBallPickupPlayerBack));
        ballPickupPlayerFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupPlayerFront,Variables.ClawPositions.wristBallPickupPlayerFront));

        defenceButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armDefence,Variables.ClawPositions.wristDefence));

        hatchScoreFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchFront,Variables.ClawPositions.wristHatchFront));
        hatchScoreBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchBack,Variables.ClawPositions.wristHatchBack));

        hatchPlayerCollectButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchPlayerGrab,Variables.ClawPositions.wristHatchPlayerGrab));
    }
}
