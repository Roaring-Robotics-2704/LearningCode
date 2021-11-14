package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ArmChangeState;

public class ArmSubsystem extends SubsystemBase {
    private final Encoder armEncoder = new Encoder(Constants.ArmConstants.encoderPorts[0],
            Constants.ArmConstants.encoderPorts[1], false, Encoder.EncodingType.k4X);
    private final PWMVictorSPX armMotor = new PWMVictorSPX(Constants.ArmConstants.armMotor);

    private Constants.State currState = Constants.State.UP;
    private Constants.State targetState = Constants.State.UP;

    public ArmSubsystem() {
        // we start with the arm up, let's reset the encoder counts here
        armEncoder.reset();
    }

    public double getNewTargetDegrees() {
        if(targetState == Constants.State.UP) {
            targetState = Constants.State.DOWN;
        }
        else {
            targetState = Constants.State.UP;
        }
        return getTargetDegrees();
    }

    private double getTargetDegrees() {
        if(targetState == Constants.State.UP) {
            return Constants.ArmConstants.upDegrees;
        }
        else {
            return Constants.ArmConstants.downDegrees;
        }
    }

    public void driveArm(double speed) {
        armMotor.set(speed);
    }

    public double getAngle() {
        // TODO: Convert to degrees
        // armEncoder.get() will return the absolute encoder counts,
        // we should convert this to be degrees to be easier to understand
        return armEncoder.get();
    }

    public void updateState() {
        // Update currstate according to our position
        // hint: Constants.ArmConstants.kDegreeTolerance
        if (currState == Constants.State.UP && Math.abs(getAngle() - Constants.ArmConstants.upDegrees) > Constants.ArmConstants.kDegreeTolerance)
        {
            // we are in state UP, but the arm is farther away from the target angle than our acceptable tolerance.
            // What state should we report?
        }
        else if (currState == Constants.State.DOWN && Math.abs(getAngle() - Constants.ArmConstants.downDegrees) > Constants.ArmConstants.kDegreeTolerance)
        {
            // Similarly, we are in state DOWN, but the arm is farther away from the target angle than our acceptable tolerance.
            // What state should we report?
        }
    }

}