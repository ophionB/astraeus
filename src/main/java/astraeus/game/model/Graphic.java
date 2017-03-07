package astraeus.game.model;

import lombok.Getter;

/**
 * Represents a single graphic that can be used by entities. Also known as GFX.
 * 
 * @author Vult-R
 */
public final class Graphic implements Comparable<Graphic> {

  /**
   * The id of this graphic.
   */
  @Getter private final int id;

  /**
   * The delay of this graphic.
   */
  @Getter private final int delay;

  /**
   * The height of this graphic.
   */
  @Getter private final int height;

  /**
   * The priority of the graphic.
   */
  @Getter private final Priority priority;

  public Graphic(int id) {
    this(id, 0, false);
  }

  /**
   * Creates a new {@link Graphic}.
   * 
   * @param id The id for this graphic.
   * 
   * @param high The flag that denotes this is a high graphic.
   */
  public Graphic(int id, boolean high) {
    this(id, 0, high);
  }

  /**
   * Creates a new {@link Graphic}.
   * 
   * @param id The id for this graphic.
   * 
   * @param delay The delay for this graphic.
   */
  public Graphic(int id, int delay) {
    this(id, delay, false);
  }

  /**
   * Creates a new {@link Graphic}.
   * 
   * @param id The id for this graphic.
   * 
   * @param delay The delay for this graphic.
   * 
   * @param high The flag that denotes this is a high graphic.
   */
  public Graphic(int id, int delay, boolean high) {
    this(Priority.NORMAL, id, delay, high);
  }

  public Graphic(Priority priority, int id) {
    this(priority, id, 0, false);
  }

  /**
   * Creates a new {@link Graphic}.
   * 
   * @param id The id for this graphic.
   *
   * @param high The flag that denotes this is a high graphic.
   */
  public Graphic(Priority priority, int id, boolean high) {
    this(priority, id, 0, high);
  }

  /**
   * Creates a new {@link Graphic}.
   * 
   * @param id The id for this graphic.
   * 
   * @param delay The delay for this graphic.
   */
  public Graphic(Priority priority, int id, int delay) {
    this(priority, id, delay, false);
  }

  /**
   * Creates a new {@link Graphic}.
   * 
   * @param id The id for this graphic.
   * 
   * @param delay The delay for this graphic.
   *
   * @param high The flag that denotes this is a high graphic.
   */
  public Graphic(Priority priority, int id, int delay, boolean high) {
    this.priority = priority;
    this.id = id;
    this.delay = delay;
    this.height = high ? 6553600 : 0;
  }

  @Override
  public int compareTo(Graphic other) {
    if (other == null) {
      return 1;
    }

    return Integer.signum(other.priority.getPriority() - priority.getPriority());
  }

  @Override
  public String toString() {
    return String.format("GRAPHIC[priority=%s, id=%s, delay=%s, height=]", priority, id, delay,
        height);
  }

}
