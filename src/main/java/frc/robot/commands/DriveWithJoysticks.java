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
  private final XboxController m_driveController;
  private double leftStickX;
  private double leftStickY;
  /** Creates a new DriveWithJoysticks. */
  
  public DriveWithJoysticks(DriveTrain dt, XboxController driveController) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    m_driveController = driveController;
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    leftStickX = 0.0;
    leftStickY = 0.0;

    // rightSpeed = 0.0;
    // leftSpeed = 0.0;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
      leftStickY = Constants.TELEOP_SPEED * GetDriverRawAxisY(Constants.XBOX_LEFT_Y_AXIS);
      leftStickX = Constants.TELEOP_SPEED * GetDriverRawAxisX(Constants.XBOX_LEFT_X_AXIS);
      driveTrain.actualDriveLol(leftStickY, leftStickX);
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
    return m_driveController.getRawAxis(axis);
  }

  public double GetDriverRawAxisY(final int axis) {
    return m_driveController.getRawAxis(axis);
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
