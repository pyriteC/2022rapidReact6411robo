// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase 
{
  Spark leftMotor;
  Spark rightMotor;
  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() 
  {
    leftMotor = new Spark(Constants.LEFT_MOTOR);
    leftMotor .setInverted(true);
    rightMotor = new Spark(Constants.RIGHT_MOTOR);
    rightMotor .setInverted(false);

    drive = new DifferentialDrive(leftMotor, rightMotor);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed)
  {
    drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
    //drive.tankDrive(controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.XBOX_RIGHT_Y_AXIS)*speed);
  }

  public void setRightMotor(double speed) {
    rightMotor.set(speed*Constants.DRIVE_TRAIN_SPEED);
  }

  public void setLeftMotor(double speed) {
    leftMotor.set(speed*Constants.DRIVE_TRAIN_SPEED);
  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }

}
