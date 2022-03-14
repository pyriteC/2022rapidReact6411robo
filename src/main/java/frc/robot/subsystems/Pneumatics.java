// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
  /** Creates a new SolenoidUp. */
  private Solenoid solenoid1;
  private Solenoid solenoid2;
  public Pneumatics() 
  {
    solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.SOLENOID_ID_1 );
    solenoid2 = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.SOLENOID_ID_2 );
  }

  public void solenoidUp()
  {
    solenoid1.set(true);
    solenoid2.set(true);
  }

  public void solenoidDown()
  {
    solenoid1.set(false);
    solenoid2.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
