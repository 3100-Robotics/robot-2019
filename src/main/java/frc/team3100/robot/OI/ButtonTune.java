package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ButtonTune extends Command {

    private Button startup = new JoystickButton(RobotMap.techControls, RobotMap.aButtonChannel);;
    private FileWriter writer;
    boolean ran = false;
    int pastVal  = 0;
    int time = 0;

    public ButtonTune() {
    super("ButtonTune");

    }

    protected void initialize() {

    }

    protected void execute() {
        System.out.println("TUNING");
        if(Robot.oi.ballPickupFrontButton.get() && pastVal != 1) {
            Robot.presetValues[0] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[1] = Robot.arm.getCurrentPosition();
            pastVal = 1;
            writeToFile();

        } else if (Robot.oi.ballPickupBackButton.get() && pastVal != 2) {
            Robot.presetValues[2] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[3] = Robot.arm.getCurrentPosition();
            pastVal = 2;
            writeToFile();

        } else if (Robot.oi.ballCargoFrontButton.get() && pastVal != 3) {
            Robot.presetValues[4] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[5] = Robot.arm.getCurrentPosition();
            pastVal = 3;
            writeToFile();

        } else if (Robot.oi.ballCargoBackButton.get() && pastVal != 4) {
            Robot.presetValues[6] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[7] = Robot.arm.getCurrentPosition();
            pastVal = 4;
            writeToFile();

        } else if (Robot.oi.ballRocketFrontButton.get() && pastVal != 5) {
            Robot.presetValues[8] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[9] = Robot.arm.getCurrentPosition();
            pastVal = 5;
            writeToFile();

        } else if (Robot.oi.ballRocketBackButton.get() && pastVal != 6) {
            Robot.presetValues[10] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[11] = Robot.arm.getCurrentPosition();
            pastVal = 6;
            writeToFile();

        } else if (Robot.oi.ballRocket2BackButton.get() && pastVal != 7) {
            Robot.presetValues[12] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[13] = Robot.arm.getCurrentPosition();
            pastVal = 7;
            writeToFile();

        } else if (Robot.oi.hatchScoreFrontButton.get() && pastVal != 8) {
            Robot.presetValues[14] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[15] = Robot.arm.getCurrentPosition();
            pastVal = 8;
            writeToFile();

        } else if (Robot.oi.hatchScoreBackButton.get() && pastVal != 9) {
            Robot.presetValues[16] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[17] = Robot.arm.getCurrentPosition();
            pastVal = 9;
            writeToFile();

        } else if (Robot.oi.hatchScoreRocketLv2Button.get() && pastVal != 10) {
            Robot.presetValues[18] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[19] = Robot.arm.getCurrentPosition();
            pastVal = 10;
            writeToFile();

        } else if (Robot.oi.defenceButton.get() && pastVal != 11) {
            Robot.presetValues[20] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[21] = Robot.arm.getCurrentPosition();
            pastVal = 11;
            writeToFile();

        } else if(Robot.oi.climbingPrep.get() && pastVal != 12) {
            Robot.presetValues[22] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[23] = Robot.arm.getCurrentPosition();
            pastVal = 12;
            writeToFile();

        } else if(Robot.oi.climbingMotonButton.get() && pastVal != 13) {
            Robot.presetValues[24] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[25] = Robot.arm.getCurrentPosition();
            pastVal = 13;
            writeToFile();
        }
        time += 1;
        if(time > 200) {
            pastVal = 0;
            time = 0;
        }
    }

    private void writeToFile() {
        try {
            System.out.println("SETTING");
            writer = new FileWriter(Robot.f);
            StringBuilder deployText = new StringBuilder();
            for(int v = 0; v < Robot.presetValues.length;v++) {
                deployText.append(Robot.presetValues[v] + " ");
            }
            writer.write(deployText.toString());
            writer.flush();
            writer.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    protected boolean isFinished() {
        return !startup.get();
    }

    protected void end() {

    }

    protected void interrupted() {

    }


}
