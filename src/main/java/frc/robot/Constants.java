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
    //need to correlate with pwm on robot 
    public static final int BACK_LEFT_MOTOR = 0;
    public static final int BACK_RIGHT_MOTOR = 3;
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int FRONT_LEFT_MOTOR = 1;

    public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_LEFT_X_AXIS = 0;
    public static final int XBOX_RIGHT_Y_AXIS = 5;

    public static final double DRIVE_TRAIN_SPEED = .7;
    public static final double DRIVE_FORWARD_TIME = 3.0;
    public static final double AUTOMOUS_SPEED = 0.4;
    public static final int JOYSTICK_RIGHT_USB_NUMBER = 0;
    public static final int JOYSTICK_LEFT_USB_NUMBER = 1;
    public static final double TURN_RAD = 1.0;
    public static final int TELEOP_SPEED = 1;
    public static final int SOLENOID_ID_1 = 0;
    public static final int SOLENOID_ID_2 = 1;
    public static final int INTAKE_MOTOR = 4;
    public static final double INTAKE_SPEED = 1;
    public static final double STOP_MOTOR = 0;
    public static final int INTAKE_BUTTON = 3;
}
