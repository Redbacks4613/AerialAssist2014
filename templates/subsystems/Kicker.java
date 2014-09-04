package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.kicker.KickerDoNothing;

public class Kicker extends Subsystem {
    //Motors
    SpeedController motor1 = new Victor(RobotMap.kickerMotor1);
    SpeedController motor2 = new Victor(RobotMap.kickerMotor2);

    DigitalInput hammerSwitch1 = new DigitalInput(RobotMap.kickerSwitch1);
    DigitalInput hammerSwitch2 = new DigitalInput(RobotMap.kickerSwitch2);
    
    public Encoder encoder = new Encoder(RobotMap.kickerEncoder1A, RobotMap.kickerEncoder1B, true, EncodingType.k4X);
    
    public void initDefaultCommand() {
        setDefaultCommand(new KickerDoNothing());
        encoder.start();
        encoder.setDistancePerPulse(0.57D);
    }
    
    public void kick()
    {
        setMotors(1D);
    }
    
    public void cock()
    {
        setMotors(-0.2D);
    }
    
    public void alignDown(double speed)
    {
        setMotors(speed);
    }
    
    public void reverse()
    {
        setMotors(-0.1D);
    }
    
    public void forward()
    {
        setMotors(0.1D);
    }
    
    public void rest()
    {
        setMotors(0.0D);
    }
    
    private void setMotors(double speed)
    {
        motor1.set(speed);
        motor2.set(speed);
    }
    
    public boolean isHammerSwitch1()
    {
        return !hammerSwitch1.get();
    }
    
    public boolean isHammerSwitch2()
    {
        return !hammerSwitch2.get();
    }
}
