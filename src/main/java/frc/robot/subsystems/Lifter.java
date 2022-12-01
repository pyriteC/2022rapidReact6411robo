// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lifter extends SubsystemBase {
  /** Creates a new lifter. */
  private Victor liftMotor;
  public Lifter() 
  {
    liftMotor = new Victor(Constants.LIFT_MOTOR);
  }

  public void setSpeed(boolean upDown)//true = up 
  {
    if (upDown)
    {
    liftMotor.set(Constants.LIFT_SPEED_UP);
    }
    else 
    {
      liftMotor.set(Constants.LIFT_SPEED_UP *-1);
    }
  }

  public void stopLiftMotor()
  {
    liftMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
