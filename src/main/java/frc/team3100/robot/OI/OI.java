package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.Autonomous.AutoClawMotion;
import frc.team3100.robot.Autonomous.AutoScore;
import frc.team3100.robot.Claw.ClawExtend;
import frc.team3100.robot.Lifter.*;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
Interfaces buttons with commands
 */
public class OI {


    public Button presetTuning = new JoystickButton(RobotMap.techControls,RobotMap.aButtonChannel);
    private Button hatchReleaseButton = new JoystickButton(RobotMap.driveControls,RobotMap.rightBumperChannel);
    public Button safetyButton = new JoystickButton(RobotMap.driveControls,RobotMap.startButtonChannel);
    public Button triggerButton = new JoystickButton(RobotMap.driveControls,RobotMap.backButtonChannel);
    //ublic Button pathButton = new JoystickButton(RobotMap.driveControls,RobotMap.aButtonChannel);



    private Button lifterActuateButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton12Channel);
    private Button sensorResetButton = new JoystickButton(RobotMap.techBoard,RobotMap.boardButton14Channel);
    public Button climbingMotonButton = new JoystickButton(RobotMap.techControls,RobotMap.bButtonChannel);
    public Button climbingPrep = new JoystickButton(RobotMap.techControls,RobotMap.xButtonChannel);


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
        presetTuning.whenPressed(new ButtonTune());
        hatchReleaseButton.whenPressed(new ClawExtend());
        lifterActuateButton.whenPressed(new LifterActuate());
        sensorResetButton.whenPressed(new SensorReset());
        safetyButton.whenPressed(new LifterSafety());
        //pathButton.whenPressed(new AutoScore());
        //climbingPrep.whenPressed(new AutoClawMotion(Variables.ClawPositions.armClimbPrep,Variables.ClawPositions.wristClimbPrep));

        ballRocketBackButton.whenPressed(new AutoClawMotion("ballRocketBack"));
        ballCargoFrontButton.whenPressed(new AutoClawMotion("ballCargoFront"));
        ballCargoBackButton.whenPressed(new AutoClawMotion("ballCargoBack"));
        ballRocketFrontButton.whenPressed(new AutoClawMotion("ballRocketFront"));
        ballRocket2BackButton.whenPressed(new AutoClawMotion("ballRocket2Back"));

        ballPickupBackButton.whenPressed(new AutoClawMotion("ballPickupBack"));
        ballPickupFrontButton.whenPressed(new AutoClawMotion("ballPickupFront"));

        defenceButton.whenPressed(new AutoClawMotion("DEF"));

        hatchScoreFrontButton.whenPressed(new AutoClawMotion("hatchScoreFront"));
        hatchScoreBackButton.whenPressed(new AutoClawMotion("hatchScoreBack"));
        hatchScoreRocketLv2Button.whenPressed(new AutoClawMotion("hatchScoreRocketLv2"));

    }
}
