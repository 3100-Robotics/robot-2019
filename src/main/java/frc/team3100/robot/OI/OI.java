package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Autonomous.AutoScore;
import frc.team3100.robot.Claw.ClawExtend;
import frc.team3100.robot.Lifter.*;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Variables;

/*
Interfaces buttons with commands
 */
public class OI {



    private Button hatchReleaseButton = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);
    public Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    public Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.backButtonChannel);
    //ublic Button pathButton = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);
    public Button presetTuning = new JoystickButton(RobotMap.techBoard,RobotMap.aButtonChannel);



    private Button lifterActuateButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton12Channel);
    public Button climbingPrep = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton13Channel);
    private Button sensorResetButton = new JoystickButton(RobotMap.techControls,RobotMap.boardButton14Channel);
    public Button climbingMotonButton = new JoystickButton(RobotMap.techBoard,RobotMap.bButtonChannel);


    public Button defenceButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton7Channel);

    public Button ballPickupBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton4Channel);
    public Button ballPickupFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton11Channel);

    public Button ballRocketBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton6Channel);
    public Button ballRocketFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton9Channel);
    public Button ballRocket2BackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton8Channel);
    public Button ballCargoFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton10Channel);
    public Button ballCargoBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton5Channel);


    public Button hatchScoreFrontButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton3Channel);
    public Button hatchScoreBackButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton1Channel);
    public Button hatchScoreRocketLv2Button = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton2Channel);




    public OI() {
        hatchReleaseButton.whenPressed(new ClawExtend());
        lifterActuateButton.whenPressed(new LifterActuate());
        sensorResetButton.whenPressed(new SensorReset());
        safetyButton.whenPressed(new LifterSafety());
        //pathButton.whenPressed(new AutoScore());
        climbingPrep.whenPressed(new AutoClawMotion(Variables.ClawPositions.armClimbPrep,Variables.ClawPositions.wristClimbPrep));

        ballRocketBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketBack,Variables.ClawPositions.wristBallScoreRocketBack));
        ballCargoFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoFront,Variables.ClawPositions.wristBallScoreCargoFront));
        ballCargoBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreCargoBack,Variables.ClawPositions.wristBallScoreCargoBack));
        ballRocketFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketFront,Variables.ClawPositions.wristBallScoreRocketFront));
        ballRocket2BackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallScoreRocketlv2, Variables.ClawPositions.wristBallScoreRocketlv2));

        ballPickupBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupBack,Variables.ClawPositions.wristBallPickupBack));
        ballPickupFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armBallPickupFront,Variables.ClawPositions.wristBallPickupFront));

        defenceButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armDefence,Variables.ClawPositions.wristDefence));

        hatchScoreFrontButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchFront,Variables.ClawPositions.wristHatchFront));
        hatchScoreBackButton.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchBack,Variables.ClawPositions.wristHatchBack));
        hatchScoreRocketLv2Button.whenPressed(new AutoClawMotion(Variables.ClawPositions.armHatchScoreRocketLv2,Variables.ClawPositions.wristHatchScoreRocketLv2));

    }
}
