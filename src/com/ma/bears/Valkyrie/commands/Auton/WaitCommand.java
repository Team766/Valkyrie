package com.ma.bears.Valkyrie.commands.Auton;

/**
 *
 * @author Blevenson
 */
import edu.wpi.first.wpilibj.command.Command;


public class WaitCommand extends Command {
  private double timeout;

  public WaitCommand(double seconds) {
    timeout = seconds;
  }
  protected void initialize() {
    setTimeout(timeout);
  }

  protected void execute() {}

  protected boolean isFinished() {
    return isTimedOut();
  }

  protected void end() {}

  protected void interrupted() {
	  end();
  }
}