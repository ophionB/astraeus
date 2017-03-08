package io.battlerune.game.model.entity.mob.player.update.mask;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.update.PlayerUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players forced text.
 * 
 * @author SeVen
 */
public class PlayerForceChatUpdateBlock extends PlayerUpdateBlock {

  /**
   * Creates a new {@link PlayerForceChatUpdateBlock}.
   */
  public PlayerForceChatUpdateBlock() {
    super(0x4, UpdateFlag.FORCED_CHAT);
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    builder.writeString(entity.getForcedChat());
  }

}
