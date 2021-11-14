// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.wpilibj.XboxController.Button;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.ArmChangeState;
import frc.robot.commands.DriveByController;
import frc.robot.commands.HatchChangeState;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HatchSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The driver's controller
  private static Joystick m_joystick = new Joystick(Constants.OIConstants.kDriverControllerPort);

  // Subsystems
  private final ArmSubsystem m_arm = new ArmSubsystem();
  private final HatchSubsystem m_hatch = new HatchSubsystem();
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();

  // Default drive command
  private final DriveByController m_driveCommand = new DriveByController(m_robotDrive, m_joystick);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(m_driveCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Change Arm State
    new JoystickButton(m_joystick, Button.kY.value)
            .whenPressed(new ArmChangeState(m_arm).withTimeout(Constants.ArmConstants.timeout));

    // Change Hatch State
    new JoystickButton(m_joystick, Button.kY.value)
            .whenPressed(new HatchChangeState(m_hatch).withTimeout(Constants.HatchConstants.timeout));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // TODO: (Bonus) Make command to drive 5 feet forward without joystick feedback (encoders only!)
    return new InstantCommand();
  }
}
