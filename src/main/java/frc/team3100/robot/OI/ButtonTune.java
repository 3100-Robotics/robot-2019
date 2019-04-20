package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

import java.io.FileWriter;
import java.io.IOException;

public class ButtonTune extends Command {

    private Button startup = Robot.oi.presetTuning;
    private int[] list = Robot.presetValues;
    private FileWriter writer;
    boolean ran = false;

    public ButtonTune() {
    super("ButtonTune");

    }

    protected void initialize() {

    }

    protected void execute() {
        System.out.println("TUNING");
        if(Robot.oi.ballPickupFrontButton.get()) {
            Robot.presetValues[0] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[1] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.ballPickupBackButton.get()) {
            Robot.presetValues[2] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[3] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.ballCargoFrontButton.get()) {
            Robot.presetValues[4] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[5] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.ballCargoBackButton.get()) {
            Robot.presetValues[6] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[7] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.ballRocketFrontButton.get()) {
            Robot.presetValues[8] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[9] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.ballRocketBackButton.get()) {
            Robot.presetValues[10] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[11] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.ballRocket2BackButton.get()) {
            Robot.presetValues[12] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[13] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.hatchScoreFrontButton.get()) {
            Robot.presetValues[14] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[15] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.hatchScoreBackButton.get()) {
            Robot.presetValues[16] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[17] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.hatchScoreRocketLv2Button.get()) {
            Robot.presetValues[18] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[19] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if (Robot.oi.defenceButton.get()) {
            Robot.presetValues[20] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[21] = Robot.arm.getCurrentPosition();
            ran = true;

        } else if(Robot.oi.climbingPrep.get()) {
            Robot.presetValues[22] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[23] = Robot.arm.getCurrentPosition();

        } else if(Robot.oi.climbingMotonButton.get()) {
            Robot.presetValues[24] = (int) Robot.wrist.getCurrentPosition();
            Robot.presetValues[25] = Robot.arm.getCurrentPosition();
            ran = true;

        }



        if(ran) {
            try {
                writer = new FileWriter(Robot.f);
                String deployText = "";
                for(int v = 0; v == Robot.presetValues.length - 1;v++) {
                    deployText = deployText + " " + Robot.presetValues[v];
                }
                writer.write(deployText);
                writer.flush();
                writer.close();
                ran = false;
            } catch(IOException e) {
                e.printStackTrace();
            }
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
