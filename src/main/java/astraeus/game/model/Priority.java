package astraeus.game.model;

import lombok.Getter;

/**
 * A list of priorities.
 * 
 * @author Michael | Chex
 */
public enum Priority {

  /** A low priority. */
  LOW(0),

  /** A medium priority. */
  NORMAL(1),

  /** A high priority. */
  HIGH(2),

  /** An extra high priority. */
  EXTRA_HIGH(3);

  /** The priority level as an integer. */
  @Getter private final int priority;

  /**
   * Constructs a new priority.
   * 
   * @param priority The priority level as an integer.
   */
  private Priority(int priority) {
    this.priority = priority;
  }

}
