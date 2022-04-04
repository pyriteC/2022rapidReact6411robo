// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class TargetingCommand extends CommandBase {
  /** Creates a new TargetCommand. */
  private final LimeLightSub m_limeLightSub;
  private final Turret m_turret;
  private final int targetPipeline = 1;
  private final int lookPipeline = 0;
  private final DigitalInput leftLimitSwitch;
  private final DigitalInput rightLimitSwitch;
  public TargetingCommand(final LimeLightSub limeSub, final Turret turretSub) 
  {
    // Use addRequirements() here to declare subsystem dependencies.
    m_limeLightSub = limeSub;
    m_turret = turretSub;
    leftLimitSwitch = new DigitalInput(Constants.LEFT_LIMIT_SWITCH);
    rightLimitSwitch = new DigitalInput(Constants.RIGHT_LIMIT_SWITCH);

    //subsystem dependencies
    addRequirements(m_limeLightSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_limeLightSub.getLimeLight().setPipeline(targetPipeline);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override

  public void execute() {
    final double x = m_limeLightSub.getLimeLight().getdegRotationToTarget();

    if (!(leftLimitSwitch.get()) && !(rightLimitSwitch.get()) )
    {
     if (x != 0 )
     {
        if (x > Constants.TARGET_AXIS)
        {
          m_turret.turnRight();
        }
        else if (x < -Constants.TARGET_AXIS)
        {
          m_turret.turnLeft();
        }
      }
    }
    else if (leftLimitSwitch.get())
    {
      m_turret.turnRight();
    }
    else if (rightLimitSwitch.get())
    {
      m_turret.turnLeft();  
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    m_limeLightSub.getLimeLight().setPipeline(lookPipeline);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
