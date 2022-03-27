// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FinalFeed extends SubsystemBase 
{
  private Victor FFMotor;
  /** Creates a new FinalFeed. */
  public FinalFeed() 
  {
    FFMotor = new Victor(Constants.FINAL_FEED_MOTOR);
  }

  public void setFFMotor()
  {
    FFMotor.set(Constants.FINAL_FEED_SPEED);
  }

  public void stopMotor()
  {
    FFMotor.set(Constants.STOP_MOTOR);
  }

  @Override
  public void periodic()
   {
    // This method will be called once per scheduler run
  }
}
