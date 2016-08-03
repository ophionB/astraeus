package astraeus.game.model;

import lombok.Getter;

/**
 * The enumeration of the brightness levels as seen by the client.
 *
 * @author Vult-R
 */
public enum Brightness {

  VERY_DARK(1),

  DARK(2),

  NORMAL(3),

  BRIGHT(4);

  @Getter private final int code;

  private Brightness(int code) {
    this.code = code;
  }

}
