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
    public static final int FRONT_LEFT_MOTOR = 1;
    public static final int FRONT_RIGHT_MOTOR = 2;
    public static final int BACK_RIGHT_MOTOR = 3;
    public static final int INTAKE_MOTOR = 4;
    public static final int SHOOT_MOTOR = 5;
    public static final int TURRET_MOTOR = 7;
    public static final int SIDE_TOWER_MOTOR = 6;
    public static final int FINAL_FEED_MOTOR = 8;
    public static final int LEFT_LIMIT_SWITCH = 0;
    public static final int RIGHT_LIMIT_SWITCH = 0;


    public static final int SOLENOID_ID_1 = 0;
    public static final int SOLENOID_ID_2 = 1;

    public static final int XBOX_USB_NUMBER = 0;

    public static final int XBOX_LEFT_Y_AXIS = 1;
    public static final int XBOX_RIGHT_Y_AXIS = 5;
    public static final int RIGHT_TRIGGER = 3;
    public static final int FEED_BUTTON = 2;
    public static final int INTAKE_BUTTON = 1;
    public static final int FINAL_FEED_BUTTON = 3;
    public static final int SHOOT_BUTTON = 5;
    public static final int SWITCH_FEEEDER_DIRECTION_BUTTON = 4;

    public static final double DRIVE_TRAIN_SPEED = 1;
    public static final double AUTOMOUS_SPEED = .8;
    public static final double TURN_RAD = 1.0;
    public static final double TELEOP_SPEED = .75; 
    public static final double INTAKE_SPEED = -.7;
    public static final double STOP_MOTOR = 0.0;
    public static final double FEEDER_SPEED = -0.4;
    public static final double TURRET_SPEED = 0.001;
    public static final double FINAL_FEED_SPEED = 0.5;
    public static final double SHOOT_SPEED = 1;
 

    public static final double TARGET_AXIS = 0.5;


    public static final double IN_PER_SEC = 90;

    public static final double DRIVE_FORWARD_TIME = 150/IN_PER_SEC ;
    public static final double DRIVE_BACK_TIME = 50/IN_PER_SEC;
    public static final double FEED_TIME = 5;
    public static final double DRIVE_OUT_TIME = 110 / IN_PER_SEC;

}
