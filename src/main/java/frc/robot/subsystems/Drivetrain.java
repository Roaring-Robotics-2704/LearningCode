package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */

    public Drivetrain() {

    }

    private double processInput(double joystickValue) {
        //TODO: implement deadband/deadzone
        //TODO: implement joystick scaling
        return joystickValue;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        //get joystick input
        //process joystick input
        //command motors
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}