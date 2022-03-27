// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.FinalFeed;

public class MoveToShoot extends CommandBase {
  /** Creates a new MoveToShoot. */
  private FinalFeed m_finalFeed;
  private XboxController xboxController;
  public MoveToShoot(FinalFeed ff, XboxController xBox) {
    // Use addRequirements() here to declare subsystem dependencies.
    xboxController = xBox;
    m_finalFeed = ff;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if (xboxController.getRawAxis(Constants.RIGHT_TRIGGER) > .1)
    {
      m_finalFeed.setFFMotor();
    }
    else 
    {
      m_finalFeed.stopMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
