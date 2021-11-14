package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HatchSubsystem extends SubsystemBase {

    private final Servo m_hatchMotor = new Servo(Constants.HatchConstants.hatchServo);

    private Constants.State m_currState = Constants.State.UP;
    private Constants.State m_targetState = Constants.State.UP;

    /** Creates a new ExampleSubsystem. */
    public HatchSubsystem() {}

    private int getTargetDegrees() {
        if(m_targetState == Constants.State.UP) {
            return Constants.HatchConstants.upDegrees;
        }
        else {
            return Constants.HatchConstants.downDegrees;
        }
    }

    public void changeTargetState() {
        if(m_targetState == Constants.State.UP) {
            m_targetState = Constants.State.DOWN;
        }
        else {
            m_targetState = Constants.State.UP;
        }
    }

    public void setAngle() {
        m_hatchMotor.setAngle(getTargetDegrees());
    }

    public double getAngle() {
        return m_hatchMotor.getAngle();
    }

    public void updateState() {
        // Update currstate according to our position
        // hint: Constants.ArmConstants.kDegreeTolerance
        if (m_currState == Constants.State.UP && Math.abs(getAngle() - Constants.ArmConstants.upDegrees) > Constants.ArmConstants.kDegreeTolerance)
        {
            // we are in state UP, but the arm is farther away from the target angle than our acceptable tolerance.
            // What state should we report?
        }
        else if (m_currState == Constants.State.DOWN && Math.abs(getAngle() - Constants.ArmConstants.downDegrees) > Constants.ArmConstants.kDegreeTolerance)
        {
            // Similarly, we are in state DOWN, but the arm is farther away from the target angle than our acceptable tolerance.
            // What state should we report?
        }
    }

    public boolean atTargetState()
    {
        return m_currState == m_targetState;
    }
}
