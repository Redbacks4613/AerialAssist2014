/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drive.Drive;

/**
 *
 * @author Developer
 */
public class Driver extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public RobotDrive driveFront = new RobotDrive(RobotMap.driveMotorFL, RobotMap.driveMotorFR);
    public RobotDrive driveRear = new RobotDrive(RobotMap.driveMotorRL, RobotMap.driveMotorRR);
    
    public Encoder encoderL = new Encoder(RobotMap.driverEncoderLA, RobotMap.driverEncoderLB, true, CounterBase.EncodingType.k4X);
    public Encoder encoderR = new Encoder(RobotMap.driverEncoderRA, RobotMap.driverEncoderRB, true, CounterBase.EncodingType.k4X);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Drive());
        double dPP = 1D;
        //encoderL.start();
        //encoderL.setDistancePerPulse(dPP);
        driveFront.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveRear.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        encoderL.start();
        encoderL.setDistancePerPulse(dPP);
        encoderL.reset();
        encoderR.start();
        encoderR.setDistancePerPulse(dPP);
        encoderR.reset();
    }
}
