/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.intake;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class IntakeAlignPulling extends CommandBase {
    
    boolean continueSequence;
    
    public IntakeAlignPulling(boolean cont) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeArm);
        continueSequence = cont;
    }

    double startPos;
    
    // Called just before this Command runs the first time
    protected void initialize() {
        startPos = intakeArm.pot.getVoltage();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(startPos < RobotMap.intakePullingPosition) 
        {
            intakeArm.lower();
        }
        else
        {
            intakeArm.raise();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(startPos < RobotMap.intakePullingPosition) 
        {
            return intakeArm.pot.getVoltage() > RobotMap.intakePullingPosition;
        }
        else
        {
            return intakeArm.pot.getVoltage() < RobotMap.intakePullingPosition;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        if(startPos >= RobotMap.intakePullingPosition)
        {
            new IntakeLower().start();
        }
        if(continueSequence)
        {
            new IntakePull().start();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
