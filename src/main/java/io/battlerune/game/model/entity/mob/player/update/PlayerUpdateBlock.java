package io.battlerune.game.model.entity.mob.player.update;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.update.UpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;

/**
 * The {@link UpdateBlock} implementation for updating players.
 * 
 * @author SeVen
 */
public abstract class PlayerUpdateBlock extends UpdateBlock<Player> {

  /**
   * Creates a new {@link PlayerUpdateBlock}.
   * 
   * @param flag The enumerated update block.
   */
  public PlayerUpdateBlock(int mask, UpdateFlag flag) {
    super(mask, flag);
  }

}
