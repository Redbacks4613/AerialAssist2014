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
public class IntakeAlignShooting extends CommandBase {
    
    CommandBase command;
    
    public IntakeAlignShooting(CommandBase com) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeArm);
        command = com;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        intakeArm.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return intakeArm.pot.getVoltage() > RobotMap.intakeMinimumHeight;
    }

    // Called once after isFinished returns true
    protected void end() {
        if(command != null)
        {
            command.start();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
