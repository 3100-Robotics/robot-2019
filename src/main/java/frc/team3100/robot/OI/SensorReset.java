package frc.team3100.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Mapping.RobotMap;
import frc.team3100.robot.Robot;


public class SensorReset extends Command {

    public SensorReset() {
        super("SensorReset");
    }

    protected void initialize() {

        int wristPosition = RobotMap.wristMotor.getSensorCollection().getAnalogInRaw();
        RobotMap.wristMotor.setSelectedSensorPosition(wristPosition);

        int armPosition = RobotMap.armMotor1.getSensorCollection().getAnalogInRaw();
        RobotMap.armMotor1.setSelectedSensorPosition(armPosition);

        Robot.ahrs.reset();
        RobotMap.leftDriveMotor1.setSelectedSensorPosition(0);
        RobotMap.rightDriveMotor1.setSelectedSensorPosition(0);
        Robot.vision.disableVisionProcessing();

    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}