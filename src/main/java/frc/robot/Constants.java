// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class ArmConstants {
        public static final int[] encoderPorts = new int[] {0, 1};
        public static final int armMotor = 2;
        public static final double kP = 1;
        public static final double kI = 0.5;
        public static final double kD = 0;

        // TODO: Find good values
        public static final double downDegrees = 200;
        public static final double upDegrees = 10;

        // Tolerances
        public static final double kDegreeTolerance = 3;
        public static final double kTurnRateToleranceDegPerS = 10; // degrees per second

        public static final int timeout = 5;
    }

    public static final class DriveConstants {
        public static int leftMotor = 0;
        public static int rightMotor = 1;
    }

    public static final class HatchConstants {
        public static int hatchServo = 4;

        // TODO: Find good values
        public static final int downDegrees = 25;
        public static final int upDegrees = 0;
        public static final int timeout = 5;
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
    }

    public enum State {
        UP,
        DOWN
    }
}
