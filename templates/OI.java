package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.Interrupt;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeAlignShooting;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeManualPull;
import edu.wpi.first.wpilibj.templates.commands.intake.IntakeSpit;
import edu.wpi.first.wpilibj.templates.commands.kicker.KickerAlignDown;
import edu.wpi.first.wpilibj.templates.commands.kicker.KickerCock;
import edu.wpi.first.wpilibj.templates.commands.kicker.KickerKick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final boolean isSingleController = false;
    
    public static final Joystick stickFunction = new Joystick(1);
    public static final Button buttonX = new JoystickButton(stickFunction, 1);
    public static final Button buttonA = new JoystickButton(stickFunction, 2);
    public static final Button buttonB = new JoystickButton(stickFunction, 3);
    public static final Button buttonY = new JoystickButton(stickFunction, 4);
    public static final Button buttonLB = new JoystickButton(stickFunction, 5);
    public static final Button buttonRB = new JoystickButton(stickFunction, 6);
    public static final Button buttonLT = new JoystickButton(stickFunction, 7);
    public static final Button buttonRT = new JoystickButton(stickFunction, 8);
    
    public static final Joystick stickDriver = new Joystick(2);
    public static final Button trigger = isSingleController ? buttonY : new JoystickButton(stickDriver, 1);
    public static final Button releasePowerConstraints = new JoystickButton(stickDriver, 9);
    public static final Button buttonInterupt = new JoystickButton(stickDriver, 11);
        
    public OI()
    {
        buttonB.whenPressed(new IntakeAlignShooting(new KickerKick()));
        buttonX.whenPressed(new KickerAlignDown(null, 0.25D));
        buttonA.whenPressed(new KickerCock());
        //buttonY.whenPressed(new IntakeAlignPulling(false));
        buttonInterupt.whenPressed(new Interrupt());
        if(!isSingleController) {
            buttonLB.whenPressed(new IntakeManualPull());
        }
        else {
            buttonRB.whenPressed(new IntakeManualPull());
        }
        if(!isSingleController) {
            buttonRB.whenPressed(new IntakeSpit());
        }
        else {
            buttonRT.whenPressed(new IntakeSpit());
        }
    }
    
    public static double getIntakeValue()
    {
        return isSingleController ? getLowerRaise() : stickFunction.getY();
    }
    
    public static double getLowerRaise()
    {
        int a = 0;
        if(buttonLB.get()) {
            a += 1;
        }
        if(buttonLT.get()) {
            a -= 1;
        }
        return (double) a;
    }
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

