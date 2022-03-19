// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
  /** Creates a new Feeder. */
  private Victor sideMotor;
  private Victor bottomMotor;
  public Feeder() 
  {
    sideMotor = new Victor(Constants.SIDE_TOWER_MOTOR);
    bottomMotor = new Victor(Constants.BOTTOM_TOWER_MOTOR);
  } 

public void setBottomMotorSpeed()
{
  bottomMotor.set(Constants.FEEDER_SPEED);
}

public void setSideMotorSpeed()
{
  sideMotor.set(Constants.FEEDER_SPEED);
}

public void stopSideMotor()
{
  sideMotor.set(Constants.STOP_MOTOR);
}

public void stopBottomMotor()
{
  bottomMotor.set(Constants.STOP_MOTOR);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
