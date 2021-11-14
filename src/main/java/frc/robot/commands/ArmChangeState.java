package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;

/** An example command that uses an example subsystem. */
public class ArmChangeState extends PIDCommand {

    private final ArmSubsystem m_arm;
    /**
     * Moves the arm to the specified angle
     *
     * @param targetAngleDegrees The angle to turn to
     * @param arm The arm subsystem
     */
    public ArmChangeState(ArmSubsystem arm) {
        super(
                new PIDController(Constants.ArmConstants.kP, Constants.ArmConstants.kI, Constants.ArmConstants.kD),
                // Close loop on angle of the arm
                arm::getAngle,
                // Set reference to target
                arm.getNewTargetDegrees(),
                // Pipe output to move the arm
                arm::driveArm,
                // Require the arm subsystem
                arm);

        // Our arm can't freely spin, so disable continous outputs
        getController().disableContinuousInput();
        // Set the controller tolerance - the delta tolerance ensures the arm is stationary at the
        // setpoint before it is considered as having reached the reference
        getController()
                .setTolerance(Constants.ArmConstants.kDegreeTolerance, Constants.ArmConstants.kTurnRateToleranceDegPerS);
        m_arm = arm;
    }

    @Override
    public boolean isFinished() {
        if(getController().atSetpoint()) {
            m_arm.updateState();
            return true;
        }
        return false;
    }
}