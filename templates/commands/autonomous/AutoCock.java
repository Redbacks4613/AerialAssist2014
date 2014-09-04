/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.templates.commands.kicker.*;

/**
 *
 * @author Developer
 */
public class AutoCock extends KickerCock {
    
    boolean limitSwitches = false;
    
    public AutoCock() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(kicker);
    }
    
    protected void initialize() {
        kicker.encoder.reset();
        super.initialize();
        if(kicker.isHammerSwitch1() && kicker.isHammerSwitch2()) 
        {
            limitSwitches = true;
        }
    }
    
    protected boolean isFinished(){
        return super.isFinished() || !limitSwitches;
    }

    // Called once after isFinished returns true
    protected void end() {
        super.end();
        new AutoMoveForwardBasic(limitSwitches, 0.75D, 2.1D, new AutoMoveForward(limitSwitches, 0.5D, 0.8D)).start();
    }
}
