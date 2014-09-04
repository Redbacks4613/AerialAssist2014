/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeDoNothing;

/**
 *
 * @author Developer
 */
public class IntakeArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    SpeedController motorArm = new Victor(RobotMap.intakeArmMotor);
    
    public AnalogChannel pot = new AnalogChannel(RobotMap.pot);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new IntakeDoNothing());
    }
    
    public void raise()
    {
        motorArm.set(pot.getVoltage() > RobotMap.intakeSlowRaisePosition ? 1.0D : 0.45D);
    }
    
    public void lower()
    {
        motorArm.set((OI.releasePowerConstraints.get() && OI.buttonY.get()) ? -1.0D : pot.getVoltage() > RobotMap.intakeSlowLowerPosition ? -0.45D : -0.9D);
    }
    
    public void rest()//Unused
    {
        backEMF();
    }
    
    public void backEMF()
    {
        motorArm.set(0D);
    }
}