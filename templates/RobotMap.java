package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    public static final int 
        driveMotorFL = 3,
        driveMotorFR = 1,
        driveMotorRL = 4,
        driveMotorRR = 2,
        intakeArmMotor = 6,    
        intakeMotor = 5,    
        kickerMotor1 = 7, 
        kickerMotor2 = 8;
    
    public static final int
        kickerSwitch1 = 1,
        kickerSwitch2 = 2,
        kickerEncoder1A = 3,
        kickerEncoder1B = 4,
        driverEncoderLA = 5,
        driverEncoderLB = 7,
        driverEncoderRA = 8,
        driverEncoderRB = 9;
    
    public static final int
        pot = 6;
    
    public static final double
        intakeMaximumHeight = 1.5D,//1
        intakeMinimumHeight = 3.9D;//3.35
    
    public static final double        
        intakeDif = intakeMaximumHeight - intakeMinimumHeight,//2.35
        intakeSlowRaisePosition = intakeMinimumHeight + intakeDif / 47 * 16,//1.8 
        intakeStandardPosition = intakeMinimumHeight + intakeDif / 9 * 5,//1.85
        intakeCatchPosition = intakeMinimumHeight + intakeDif / 47 * 24,//2.2
        intakeSlowLowerPosition = intakeMinimumHeight + intakeDif / 47 * 35,//2.75
        intakePullingPosition = intakeMinimumHeight + intakeDif / 2,//2.9
        intakeShootingPosition = intakeMaximumHeight;//3.1
        
    public static final int
        kickerCockedPosition = -190;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    }
