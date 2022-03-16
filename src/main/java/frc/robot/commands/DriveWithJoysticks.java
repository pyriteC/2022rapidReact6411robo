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
  private final XboxController m_driveControllerLeft;
  private double rightStickX;
  private double rightStickY;
  private double leftStickX;
  private double leftStickY;
  private double righty;
  private double lefty;
  /** Creates a new DriveWithJoysticks. */
  
  public DriveWithJoysticks(DriveTrain dt, XboxController driveControllerRight, XboxController driveControllerLeft) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    m_driveControllerRight = driveControllerRight;
    m_driveControllerLeft = driveControllerLeft;
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
      rightStickY = Constants.TELEOP_SPEED * GetDriverRawAxisY(Constants.XBOX_RIGHT_Y_AXIS) * -1;
      rightStickX = Constants.TELEOP_SPEED * GetDriverRawAxisX(Constants.XBOX_RIGHT_X_AXIS) * -1;
      leftStickY = Constants.TELEOP_SPEED * GetDriverRawAxisLeftY(Constants.XBOX_LEFT_Y_AXIS)* -1;
      leftStickX = Constants.TELEOP_SPEED * GetDriverRawAxisLeftX(Constants.XBOX_LEFT_X_AXIS)* -1;
      //driveTrain.actualArcadeDrive(rightStickY, rightStickX);
       driveTrain.actualTankDrive(leftStickY, rightStickY);
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

  public double GetDriverRawAxisX(final int axis) {
    return m_driveControllerRight.getRawAxis(axis);
  }

  public double GetDriverRawAxisY(final int axis) {
    return m_driveControllerRight.getRawAxis(axis);
  }

  public double GetDriverRawAxisLeftX(final int axis) {
    return m_driveControllerLeft.getRawAxis(axis);
  }

  public double GetDriverRawAxisLeftY(final int axis) {
    return m_driveControllerLeft.getRawAxis(axis);
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
