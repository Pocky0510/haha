// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.candle;
import frc.robot.subsystems.chassis;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final chassis mChassis = new chassis();
  private final candle mCandle = new candle();
  // Replace with CommandPS4Controller or CommandJoystick if needed
  
  private XboxController Joystick = new XboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  
      
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
   
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

    new JoystickButton(Joystick, 1).whileTrue(new InstantCommand(mCandle::startRainbowAnimation)).onFalse(new InstantCommand(mCandle::stopAnimation));
     new JoystickButton(Joystick, 2).whileTrue(new InstantCommand(mCandle::setStaticColor)).onFalse(new InstantCommand(mCandle::stopAnimation));
     new JoystickButton(Joystick, 3).whileTrue(new InstantCommand(mCandle::startRainbowAnimation));
     new JoystickButton(Joystick, 4).onTrue(new InstantCommand(mCandle::startRainbowAnimation));
     new JoystickButton(Joystick, 0).onTrue(new InstantCommand(mCandle::startRainbowAnimation));
     new POVButton(Joystick, 0).onTrue(new InstantCommand(mCandle::startStrobeAnimation));
    
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

}
