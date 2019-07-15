package frc.team3100.robot.Claw;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

/*
This command takes the two trigger inputs on the Driver's controller and makes the claw motors move accordingly.
 */

public class ClawRotate extends Command {
    private boolean hatchExtendedCheck;
    private double direcMod = 1;
    private int time = 100;
    public ClawRotate() {
        super("ClawRotate");
        requires(Robot.claw);
    }

    protected void initialize() {
        hatchExtendedCheck = Variables.hatchExtended;
    }

    protected void execute() {

        /*
        if((RobotMap.driveControls.getRightTrigger() > .2 || RobotMap.driveControls.getLeftTrigger() > .2) && (hatchExtendedCheck != Variables.hatchExtended)) {
            direcMod = -1;
        }

        if(RobotMap.driveControls.getRightTrigger() < .2 && RobotMap.driveControls.getLeftTrigger() < .2) {
            hatchExtendedCheck = Variables.hatchExtended;
            direcMod = 1;
        }*/

        if(Variables.hatchExtended && !RobotMap.cargoSwitch.get()){
            Robot.claw.extend(!Variables.hatchExtended);
            time = 0;
            Robot.table.getEntry("ledMode").setNumber(0);
            RobotMap.backLED.set(true);
            Variables.hatchExtended = !Variables.hatchExtended;
        } else if(!Variables.hatchExtended && !RobotMap.hatchLeftSwitch.get() && !RobotMap.hatchRightSwitch.get()) {
            Robot.claw.extend(!Variables.hatchExtended);
            Robot.table.getEntry("ledMode").setNumber(0);
            time = 0;
            Variables.hatchExtended = !Variables.hatchExtended;
            RobotMap.backLED.set(true);
        }

        if(time == 40) {
            Robot.table.getEntry("ledMode").setNumber(1);
            RobotMap.backLED.set(false);
        }

        /*
        if(Variables.hatchExtended && (RobotMap.driveControls.getRightTrigger() > .2 || RobotMap.driveControls.getLeftTrigger() > .2)) {
            Robot.claw.wheels(1*direcMod,1*direcMod);
        } else if(!Variables.hatchExtended && (RobotMap.driveControls.getRightTrigger() > .2 || RobotMap.driveControls.getLeftTrigger() > .2)) {
            Robot.claw.wheels(-1*direcMod,-1*direcMod);
        } else if(!RobotMap.hatchLeftSwitch.get() || !RobotMap.hatchRightSwitch.get()) {
            Robot.claw.wheels(-.3*direcMod,-.3*direcMod);
        } else {
            Robot.claw.wheels(0,0);
        }*/



        if(RobotMap.driveControls.getRightTrigger() > .2) {
            Robot.claw.wheels(1,1);
        } else if(RobotMap.driveControls.getLeftTrigger() > .2) {
            Robot.claw.wheels(-1,-1);
        } else if(!RobotMap.hatchLeftSwitch.get() || !RobotMap.hatchRightSwitch.get()) {
            if(RobotMap.armMotor1.getOutputCurrent() > .3) {
                direcMod = 0;
            } else {
                direcMod = 0;
            }
            Robot.claw.wheels(-.6*direcMod,-.6*direcMod);
        } else {
            Robot.claw.wheels(0,0);
        }
        time += 1;
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
