package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.HatchSubsystem;

/** An example command that uses an example subsystem. */
public class HatchChangeState extends CommandBase {

    private final HatchSubsystem m_hatch;
    /**
     * Moves the arm to the specified angle
     *
     * @param hatch The hatch subsystem
     */
    public HatchChangeState(HatchSubsystem hatch) {
        m_hatch = hatch;
    }

    @Override
    public void execute()
    {
        m_hatch.setAngle();
    }

    @Override
    public boolean isFinished() {
        return m_hatch.atTargetState();
    }
}