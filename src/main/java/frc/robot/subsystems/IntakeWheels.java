// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeWheels extends SubsystemBase {
  /** Creates a new IntakeWheels. */
  private Victor intakeMotor;
  public IntakeWheels() 
  {
    intakeMotor = new Victor(Constants.INTAKE_MOTOR);
  }

  public void setIntakeMotor()
  {
    intakeMotor.set(Constants.INTAKE_SPEED);
  }

  public void stopIntakeMotor()
  {
    intakeMotor.set(Constants.STOP_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
