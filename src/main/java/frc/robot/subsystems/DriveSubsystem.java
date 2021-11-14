package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    PWMVictorSPX m_left = new PWMVictorSPX(1);
    PWMVictorSPX m_right = new PWMVictorSPX(2);
    public DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    // TODO: Add Encoders

    public DriveSubsystem() {

    }

    /**
     * Drives the robot using arcade controls.
     *
     * @param fwd the commanded forward movement
     * @param rot the commanded rotation
     */
    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }
}