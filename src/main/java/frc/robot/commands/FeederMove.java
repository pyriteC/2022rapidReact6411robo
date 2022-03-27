// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Feeder;

public class FeederMove extends CommandBase {
  /** Creates a new FeederMove. */
  private Feeder m_feeder;
  private int DPad;
  private XboxController xboxController;
  public FeederMove(Feeder feed, XboxController POV) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    xboxController = POV;
    m_feeder = feed;
    addRequirements(m_feeder);;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    DPad = xboxController.getPOV();
    if (DPad == 0|| DPad == 7 || DPad == 1 )
    {
      m_feeder.setSideMotorSpeedUp();
    }
    else if (DPad == 4 || DPad == 5 || DPad == 6)
    {
      m_feeder.setSideMotorSpeedDown();
    }
    else 
    {
      m_feeder.stopSideMotor();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    m_feeder.stopSideMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
