// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeWheels;
import frc.robot.subsystems.Pneumatics;

public class Autonomous extends CommandBase {
  private DriveTrain driveTrain;
  private boolean finish = false;
  private IntakeWheels intakeWheels;
  private Pneumatics inPnuematics;
  private Timer moveTimer;
  private Timer intakeTimer;
  /** Creates a new DriveForwardTimed. */
  public Autonomous(DriveTrain dt, IntakeWheels iw, Pneumatics pn) 
  {

    driveTrain = dt;
    intakeWheels  = iw;
    inPnuematics = pn;
    addRequirements(driveTrain, intakeWheels, inPnuematics);
    moveTimer = new Timer();
    intakeTimer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    moveTimer.reset();
    moveTimer.start();
    intakeTimer.reset();
    while(moveTimer.get() < Constants.DRIVE_FORWARD_TIME)
    {
      driveTrain.driveForward(Constants.AUTOMOUS_SPEED);
    }
    intakeTimer.start();
    while(intakeTimer.get()< Constants.AUTO_INTAKE_TIME)
    {
      driveTrain.driveForward(Constants.AUTOMOUS_SPEED);
      inPnuematics.solenoidUp();
      intakeWheels.setIntakeMotor();

    }
    finish = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
