/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.drive.TimedMove;
import edu.wpi.first.wpilibj.templates.commands.kicker.KickerKick;

/**
 *
 * @author Developer
 */
public class AutoMoveForwardBasic extends CommandBase {
    
    double reqDistance;
    boolean limitSwitches;
    
    CommandBase command;
    double speed;
    
    public AutoMoveForwardBasic(boolean ls, double sp, double metres, CommandBase com) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driver);
        limitSwitches = ls;
        reqDistance = 564.75 * metres; //564.75 is the average number of pulses per metre.
        speed = sp;
        command = com;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driver.encoderR.reset();
        driver.encoderL.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        double rotation = 0;
                
        driver.driveFront.arcadeDrive(rotation, speed);
        driver.driveRear.arcadeDrive(rotation, speed);        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driver.encoderL.getDistance() < -reqDistance &&
               driver.encoderR.getDistance() > reqDistance;
    }

    // Called once after isFinished returns true
    protected void end() {
        //new TimedMove(0.5D, 0.5D, new TimedMove(0.25D, 0.25D, limitSwitches ? new KickerKick() : null)).start();
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
