// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.IntakeWheels;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;

public class Autonomous extends CommandBase {
  private DriveTrain driveTrain;
  private boolean finish = false;
  private IntakeWheels intakeWheels;
  private Pneumatics inPnuematics;
  private Feeder feeder;
  private Shooter shooter;

  private Timer moveTimer;
  private Timer moveBack;
  private Timer feedTime;

  /** Creates a new DriveForwardTimed. */
  public Autonomous(DriveTrain dt, IntakeWheels iw, Pneumatics pn, Feeder feeder, Shooter shooter) 
  {

    driveTrain = dt;
    intakeWheels  = iw;
    inPnuematics = pn;
    this.feeder = feeder;
    this.shooter = shooter;
    addRequirements(driveTrain, intakeWheels, inPnuematics, this.feeder);
    moveTimer = new Timer();
    moveBack = new Timer();
    feedTime = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    moveTimer.reset();
    moveTimer.start();
    moveBack.reset();
    inPnuematics.solenoidUp();
    intakeWheels.setIntakeMotor();
    while(moveTimer.get() < Constants.DRIVE_FORWARD_TIME)
    {
      driveTrain.driveForward(Constants.AUTOMOUS_SPEED);
    }
    moveBack.start();
    intakeWheels.stopIntakeMotor();
    inPnuematics.solenoidDown();
    while(moveBack.get() < Constants.AUTO_INTAKE_TIME)
    {
      driveTrain.driveForward(Constants.AUTOMOUS_SPEED * -1);
    }
    feeder.setSideMotorSpeed();
    shooter.setShootSpeed();
    while(feedTime.get() < Constants.FEED_TIME)
    {}
    feeder.stopSideMotor();
    shooter.stopShoot();
    while(moveTimer.get() < Constants.DRIVE_OUT_TIME)
    {
      driveTrain.driveForward(Constants.AUTOMOUS_SPEED);
    }
    
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
