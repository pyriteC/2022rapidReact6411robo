// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Autonomous;
import frc.robot.commands.TeleOperated;
import frc.robot.commands.FeederMove;
import frc.robot.commands.Intake;
import frc.robot.commands.Lift;
import frc.robot.commands.Shoot;
import frc.robot.commands.SwitchFeedDirection;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.IntakeWheels;
import frc.robot.subsystems.Lifter;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //Drivetrian declair
  private final DriveTrain driveTrain;
  private final TeleOperated driveWithJoysticks;
  private final Autonomous driveForwardTimed;
  public static XboxController xBoxController;

  private final IntakeWheels m_intakeWheels = new IntakeWheels();
  private final Pneumatics m_pneumatics = new Pneumatics();
  private final Intake m_intake = new Intake(m_pneumatics, m_intakeWheels);
  private final Feeder m_feeder = new Feeder();
  private final FeederMove m_moveFeed = new FeederMove(m_feeder);
  private final Shooter m_shooter = new Shooter();
  private final Shoot m_shoot = new Shoot(m_shooter); 
  private final SwitchFeedDirection m_switchFeedDirection = new SwitchFeedDirection();
  private final Lifter m_lifter = new Lifter();
  private final Lift m_liftUp = new Lift(m_lifter, true);
  private final Lift m_liftDown = new Lift(m_lifter, false);

  private static int feedDirection = 1;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    xBoxController = new XboxController(Constants.XBOX_USB_NUMBER);

    driveTrain = new DriveTrain();
    driveWithJoysticks = new TeleOperated(driveTrain, xBoxController);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);

    driveForwardTimed = new Autonomous(driveTrain, m_intakeWheels,m_pneumatics, m_feeder, m_shooter );
    driveForwardTimed .addRequirements(driveTrain);

  

 

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    final JoystickButton intakeButton = new JoystickButton(xBoxController, Constants.INTAKE_BUTTON);

    intakeButton.toggleWhenPressed(m_intake);

    final JoystickButton feederButton = new JoystickButton(xBoxController, Constants.FEED_BUTTON);

    feederButton.whenHeld(m_moveFeed);

    final JoystickButton shootButton = new JoystickButton(xBoxController, Constants.SHOOT_BUTTON);
    shootButton.toggleWhenPressed(m_shoot);

    final JoystickButton switchFeederDirectionButton = new JoystickButton(xBoxController, Constants.SWITCH_FEEEDER_DIRECTION_BUTTON);
    switchFeederDirectionButton.whileHeld(m_switchFeedDirection);

    final JoystickButton LiftUpButton = new JoystickButton(xBoxController, Constants.LIFT_UP_BUTTON);
    LiftUpButton.whenHeld(m_liftUp);

    final JoystickButton LiftDownButton = new JoystickButton(xBoxController, Constants.LIFT_DOWN_BUTTON);
    LiftUpButton.whenHeld(m_liftDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return driveForwardTimed;
  }


  public static int getFeedDirection()
  {
    return feedDirection;
  }

  public static void switchFeedDirection() 
  {
    feedDirection = feedDirection * -1;
  }
}