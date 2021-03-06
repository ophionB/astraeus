package com.astraeus.game.world.entity.mob.player.update.mask;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.update.PlayerUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.game.GamePacketBuilder;

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
