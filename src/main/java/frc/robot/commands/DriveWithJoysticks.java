// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveWithJoysticks extends CommandBase 
{
  private final DriveTrain driveTrain;
  private final XboxController m_driveControllerRight;

  private double rightStickX;
  private double rightStickY;
  private double leftStickX;
  private double leftStickY;
  private double righty;
  private double lefty;
  /** Creates a new DriveWithJoysticks. */
  
  public DriveWithJoysticks(DriveTrain dt, XboxController driveControllerRight) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    m_driveControllerRight = driveControllerRight;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    // leftStickX = 0.0;
    // leftStickY = 0.0;

    // rightSpeed = 0.0;
    // leftSpeed = 0.0;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
      rightStickY = Constants.TELEOP_SPEED * getDriverRawAxisY(Constants.XBOX_RIGHT_Y_AXIS) * -1 * (getDriverSliderAxis(Constants.XBOX_SLIDER_AXIS) + 1) /2;
      rightStickX = Constants.TELEOP_SPEED * getDriverRawAxisX(Constants.XBOX_RIGHT_X_AXIS) * -1 * (getDriverSliderAxis(Constants.XBOX_SLIDER_AXIS) + 1) /2;
      leftStickY = Constants.TELEOP_SPEED * getDriverRawAxisLeftY(Constants.XBOX_LEFT_Y_AXIS)* -1 * (getDriverSliderAxis(Constants.XBOX_SLIDER_AXIS) + 1) /2;
      leftStickX = Constants.TELEOP_SPEED * getDriverRawAxisLeftX(Constants.XBOX_LEFT_X_AXIS)* -1 * (getDriverSliderAxis(Constants.XBOX_SLIDER_AXIS) + 1) /2;
      //driveTrain.actualArcadeDrive(rightStickY, rightStickX);
      driveTrain.actualTankDrive(leftStickY, leftStickY);
      //  driveTrain.setLeftMotor(leftStickY);
      //  driveTrain.setRightMotor(rightStickY);
    /*rookie solution arcade
    leftStickY = m_driveController.getRawAxis(Constants.XBOX_LEFT_Y_AXIS);
    leftStickX = m_driveController.getRawAxis(Constants.XBOX_LEFT_X_AXIS);
    
    rightSpeed = leftStickY - (leftStickX  * Constants.TURN_RAD);
    leftSpeed = leftStickY - (leftStickX * Constants.TURN_RAD);

    driveTrain.setRightMotor(rightSpeed);
    driveTrain.setLeftMotor(leftSpeed);
     */

    //arcade method
    // driveTrain.driveWithArcade(RobotContainer.driverJoystick, Constants.DRIVE_TRAIN_SPEED);

    //tank method 
    //driveTrain.driveWithTank(RobotContainer.driverJoystick, Constants.DRIVE_TRAIN_SPEED);
  }

  public double getDriverRawAxisX(final int axis) {
    return m_driveControllerRight.getRawAxis(axis);
  }

  public double getDriverRawAxisY(final int axis) {
    return m_driveControllerRight.getRawAxis(axis);
  }

  public double getDriverRawAxisLeftX(final int axis) {
    return m_driveControllerLeft.getRawAxis(axis);
  }

  public double getDriverRawAxisLeftY(final int axis) {
    return m_driveControllerLeft.getRawAxis(axis);
  }

  public double getDriverSliderAxis(final int axis)
  {
    return m_driveControllerRight.getRawAxis(axis);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
