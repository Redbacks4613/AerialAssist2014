/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.kicker;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeAlignCock;

/**
 *
 * @author Developer
 */
public class KickerAlignDown extends CommandBase {
    
    CommandBase com;
    double speed;
    
    public KickerAlignDown(CommandBase commandOnExit, double sp) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(kicker);
        com = commandOnExit;
        speed = sp;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        new IntakeAlignCock().start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(intakeArm.pot.getVoltage() > RobotMap.intakeStandardPosition)
        {
            kicker.alignDown(speed);
        }
        System.out.println("Kicker: " + kicker.encoder.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return kicker.isHammerSwitch1() && kicker.isHammerSwitch2();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.err.println("Ending kicker align down.");
        kicker.encoder.reset();
        new KickerReverse().start();
        if(com != null)
        {
            com.start();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
