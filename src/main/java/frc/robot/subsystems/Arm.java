package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Arm extends SubsystemBase {
    private Encoder armEncoder = new Encoder(RobotMap.armEncoderPort, RobotMap.armEncoderPort, false, Encoder.EncodingType.k4X);


    /** Creates a new ExampleSubsystem. */
    public Arm() {}

    public void moveArm() {
        //Identify target state
        //Move towards target
        //IsFinished()?
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}