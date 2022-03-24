// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import limelightvision.limelight.frc.LimeLight;

public class LimeLightSub extends SubsystemBase {
  /** Creates a new limeLight. */
  public LimeLight limeLight;

  public LimeLightSub() {
    limeLight = new LimeLight();
  }

  @Override
  public void periodic() { }

  public LimeLight getLimeLight(){
    return limeLight;
  }
}