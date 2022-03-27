// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private Victor shootMotor;
  /** Creates a new shoot. */
  public Shooter() 
  {
    shootMotor = new Victor(Constants.SHOOT_MOTOR);
  }

  public void setShootSpeed()
  {
    shootMotor.set(Constants.SHOOT_SPEED);
  }

  public void stopShoot()
  {
    shootMotor.set(Constants.STOP_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
