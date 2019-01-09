package frc.team3100.robot.Drivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/*
Creates an interface between an encoder and PID system; currently used within the drive train since there are two
separate PIDs within the same Subsystem.
 */

public class EncoderPIDSource implements PIDSource {
    Encoder encoder;
    PIDSourceType type = PIDSourceType.kDisplacement;
    public EncoderPIDSource(Encoder encoder) {
        this.encoder = encoder;

    }

    public void setPIDSourceType(PIDSourceType type) {
        this.type = type;
    }

    public PIDSourceType getPIDSourceType() {
        return type;
    }

    public double pidGet() {
        if(type == PIDSourceType.kDisplacement)
            return encoder.get();
        else {
            return encoder.getRate();
        }
    }
}
