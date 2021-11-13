package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Drivetrain extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */

    public Drivetrain() {
    }

    private double processInput(double joystickValue) {
        //TODO: implement deadband/deadzone
        if (-Constants.deadBand <= joystickValue && joystickValue <= Constants.deadBand){
            return 0;
        }
        //TODO: implement joystick scaling
        if (joystickValue <= 0){
            return - Math.pow(joystickValue, Constants.inputScaling);
        }
        else{
            return Math.pow(joystickValue, Constants.inputScaling);
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        //get joystick input
        //process joystick input
        //command motors
        double forwardInput = RobotContainer.controller.getY();
        double turnInput = RobotContainer.controller.getZ();

        double processedInput = processInput(forwardInput);

        if(turnInput > 0 ){
            //turn right
            RobotContainer.leftMotors.set(processedInput);
            RobotContainer.rightMotors.set(turnInput * processedInput);
        }
        if (turnInput < 0 ){
            //turn left
            RobotContainer.leftMotors.set(turnInput * processedInput);
            RobotContainer.rightMotors.set(processedInput);
        }
        else{
            RobotContainer.leftMotors.set(processedInput);
            RobotContainer.rightMotors.set(processedInput);
        }
        /*
        if turn input = 0 then left:right, 1:1 --- drive straight
        if turn input = 1 then left:right, 1:0 --- turn quickly to the right, turns at a 90 degree angle
        if turn input = -1 then left:right, 0:1 --- turn quickly to the left, turns at a 90 degree angle
        if turn input = 0.5 then left:right, 2:1 --- turn 45 degree to the right, turn on an arc
        if turn input = -0.25 then left:right, 1:4 --- turn on an arc to the left
        if turn to the right then denominator of the fraction: 1, left:right 1:input
        if turn to the left them 1: denominator of the function, left:right input:1
         */


    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}