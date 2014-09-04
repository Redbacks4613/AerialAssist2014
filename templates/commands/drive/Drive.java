/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Developer
 */
public class Drive extends CommandBase {
    
    public Drive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driver);
    }

    Joystick primaryStick = OI.isSingleController ? OI.stickFunction : OI.stickDriver;
    double stickX;
    double stickY;
    double valueZ;
        
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        stickX = primaryStick.getX();
        stickY = primaryStick.getY();
        
        if(OI.trigger.get()) {
            //stickX *= 3/4;
            stickY /= 2;
        }/*
        else {
            stickX *= Math.abs(stickX);
        }*/
        stickX *= Math.abs(stickX)/* * Math.abs(stickX)*/;
        
        
        valueZ = primaryStick.getZ();
        
        double speed = -stickY;
        double rotation = -stickX;
                
        driver.driveFront.arcadeDrive(rotation, speed);
        driver.driveRear.arcadeDrive(rotation, speed);
        
        System.out.println("Drive(L - 5, 6): " + driver.encoderL.getDistance());
        System.out.println("Drive(R - 7, 8): " + driver.encoderR.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
