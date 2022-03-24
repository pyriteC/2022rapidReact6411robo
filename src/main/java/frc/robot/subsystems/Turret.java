// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Turret extends SubsystemBase {
  /** Creates a new Turret. */
  private Victor turretMotor;
  public Turret() 
  {
    turretMotor = new Victor(Constants.TURRET_MOTOR);
  }

  public void turnRight()
  {
    turretMotor.set(Constants.TURRET_SPEED);
  }

  public void turnLeft()
  {
    turretMotor.set(Constants.TURRET_SPEED * -1);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
