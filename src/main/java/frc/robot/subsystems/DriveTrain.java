// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase 
{
  Victor backLeftMotor;
  Victor frontLeftMotor;
  Victor backRightMotor;
  Victor frontRightMotor;
  MotorControllerGroup leftMotor;
  MotorControllerGroup rightMotor;
  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() 
  {
    backLeftMotor = new Victor(Constants.BACK_LEFT_MOTOR);
    backLeftMotor .setInverted(true);
    frontLeftMotor = new Victor(Constants.FRONT_LEFT_MOTOR);
    frontLeftMotor .setInverted(true);
    backRightMotor = new Victor(Constants.BACK_RIGHT_MOTOR);
    backRightMotor .setInverted(false);
    frontRightMotor = new Victor(Constants.FRONT_RIGHT_MOTOR);
    frontRightMotor .setInverted(false);
    MotorControllerGroup leftMotor = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    MotorControllerGroup rightMotor = new MotorControllerGroup(frontRightMotor, backRightMotor);
    drive = new DifferentialDrive(leftMotor, rightMotor);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
 
  public void driveWithArcade(XboxController controller, double speed)
  {
    //drive.arcadeDrive(controller.getRawAxis(Constants.XBOX_LEFT_AXIS)*speed, controller.getRawAxis(Constants.XBOX_LEFT_AXIS)*speed);
    
  }

  public void driveWithTank(XboxController controller, double speed)
  {
    //drive.tankDrive(controller.getRawAxis(Constants.XBOX_LEFT_AXIS)*speed, controller.getRawAxis(Constants.XBOX_RIGHT_AXIS)*speed);
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

  public void actualArcadeDrive(double speed, double turn) {
    drive.arcadeDrive(-speed, turn);
  }
  
  public void actualTankDrive(double left, double right)
  {
    drive.tankDrive(left, right);
  }

}
