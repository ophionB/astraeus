package astraeus.game.task.impl;

import astraeus.game.task.Task;

/**
 * The {@link Task} that will only execute one time.
 *
 * @author Vult-R
 */
public abstract class RunOnceTask extends Task {

  /**
   * Creates a new {@link RunOnceTask}.
   */
  public RunOnceTask(DuplicatePolicy duplicatePolicy) {
    this(0, true, duplicatePolicy);
  }

  /**
   * Creates a new {@link RunOnceTask}.
   *
   * @param immediate The flag that indicates this task will be executed right away.
   */
  public RunOnceTask(boolean immediate, DuplicatePolicy duplicatePolicy) {
    this(0, immediate, duplicatePolicy);
  }

  /**
   * Creates a new {@link RunOnceTask}.
   *
   * @param delay The delay in game ticks this task will sleep for
   */
  public RunOnceTask(int delay, DuplicatePolicy duplicatePolicy) {
    this(delay, true, duplicatePolicy);
  }

  /**
   * Creates a new {@link RunOnceTask}.
   *
   * @param delay The delay in game ticks this task will sleep for
   * @param immediate The flag that indicates this task will be executed right away.
   * @param duplicatePolicy The policy for duplicate stacks
   */
  public RunOnceTask(int delay, boolean immediate, DuplicatePolicy duplicatePolicy) {
    super("runOnceTask", Task.DEFAULT_INSTANCE, delay, immediate, duplicatePolicy);
  }

  @Override
  public void execute() {
    stop();
  }

  @Override
  public abstract void onStop();

}
