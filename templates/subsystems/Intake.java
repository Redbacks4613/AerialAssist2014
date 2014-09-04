/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeDoNothing;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeWheelDoNothing;

/**
 *
 * @author Developer
 */
public class Intake extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //SpeedController motorArm = new Victor(RobotMap.intakeArmMotor);
    SpeedController motorPull = new Victor(RobotMap.intakeMotor);
    
    //public AnalogChannel pot = new AnalogChannel(RobotMap.pot);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IntakeWheelDoNothing());
    }
    
    public void pull()
    {
        motorPull.set(1.0D);
    }
    
    public void spit()
    {
        motorPull.set(-1.0D);
    }
    
    public void stopSpinning()
    {
        motorPull.set(0.0D);
    }
}
