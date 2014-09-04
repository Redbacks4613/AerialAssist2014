/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.kicker;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeAlignShooting;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeAlignUp;

/**
 *
 * @author Developer
 */
public class KickerKick extends CommandBase {
    
    public KickerKick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(kicker);
        //setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        new IntakeAlignShooting(null).start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(intakeArm.pot.getVoltage() > RobotMap.intakeShootingPosition)
        {
            kicker.kick();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return kicker.encoder.getDistance() >= 360;//isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        new KickerAlignDown(new IntakeAlignUp(), -0.05D).start();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
