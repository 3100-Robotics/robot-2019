package frc.team3100.robot.Mapping;

import edu.wpi.first.wpilibj.Joystick;

public class ButtonBoard extends Joystick {

    public ButtonBoard(int port) {
        super(port);
    }

    public boolean getButton1() { return getRawButton(RobotMap.boardButton1Channel);}
    public boolean getButton2() { return getRawButton(RobotMap.boardButton2Channel);}
    public boolean getButton3() { return getRawButton(RobotMap.boardButton3Channel);}
    public boolean getButton4() { return getRawButton(RobotMap.boardButton4Channel);}
    public boolean getButton5() { return getRawButton(RobotMap.boardButton5Channel);}

    public boolean getButton6() { return getRawButton(RobotMap.boardButton6Channel);}
    public boolean getButton7() { return getRawButton(RobotMap.boardButton7Channel);}
    public boolean getButton8() { return getRawButton(RobotMap.boardButton8Channel);}
    public boolean getButton9() { return getRawButton(RobotMap.boardButton9Channel);}
    public boolean getButton10() { return getRawButton(RobotMap.boardButton10Channel);}

    public boolean getButton11() { return getRawButton(RobotMap.boardButton11Channel);}
    public boolean getButton12() { return getRawButton(RobotMap.boardButton12Channel);}
    public boolean getButton13() { return getRawButton(RobotMap.boardButton13Channel);}
    public boolean getButton14() { return getRawButton(RobotMap.boardButton14Channel);}
    public boolean getButton15() { return getRawButton(RobotMap.boardButton15Channel);}

    public boolean getButton16() { return getRawButton(RobotMap.boardButton16Channel);}
    public boolean getButton17() { return getRawButton(RobotMap.boardButton17Channel);}
    public boolean getButton18() { return getRawButton(RobotMap.boardButton18Channel);}
    public boolean getButton19() { return getRawButton(RobotMap.boardButton19Channel);}
    public boolean getButton20() { return getRawButton(RobotMap.boardButton20Channel);}



}
