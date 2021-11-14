package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveByController extends CommandBase {
    private final DriveSubsystem m_robotDrive;
    private final Joystick m_joystick;

    public DriveByController(DriveSubsystem drive, Joystick joystick) {
        m_robotDrive = drive;
        m_joystick = joystick;
        addRequirements(m_robotDrive);
    }

    @Override
    public void execute() {
        m_robotDrive.arcadeDrive(m_joystick.getY(), m_joystick.getZ());
    }

}
