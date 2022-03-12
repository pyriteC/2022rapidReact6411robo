// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeWheels;
import frc.robot.subsystems.Pneumatics;

public class Intake extends CommandBase {
  /** Creates a new PneumaticsUp. */
  private boolean isUp = true;
  private Pneumatics m_pneumatics;
  private IntakeWheels m_intakeWheels;
  public Intake(Pneumatics p, IntakeWheels i ) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pneumatics = p;
    m_intakeWheels = i;
    addRequirements(m_pneumatics, m_intakeWheels);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    isUp = !isUp;
    if (isUp = true)
    {
      m_pneumatics.solenoidDown();
      m_intakeWheels.stopIntakeMotor();
    }
    else 
    {
      m_pneumatics.solenoidUp();
      m_intakeWheels.setIntakeMotor();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    

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
