// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Feeder extends SubsystemBase {
  /** Creates a new Feeder. */
  private Victor sideMotor;
  private Victor finalMotor;
  public Feeder() 
  {
    sideMotor = new Victor(Constants.SIDE_TOWER_MOTOR);
    finalMotor = new Victor(Constants.FINAL_FEED_MOTOR);    
  } 


public void setSideMotorSpeed()
{
  sideMotor.set(Constants.FEEDER_SPEED *RobotContainer.getFeedDirection());
  finalMotor.set(Constants.FINAL_FEED_SPEED *RobotContainer.getFeedDirection());
}


public void stopSideMotor()
{
  sideMotor.set(Constants.STOP_MOTOR);
  finalMotor.set(Constants.STOP_MOTOR);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
