package com.astraeus.game.world.entity.mob.player.update.mask;

import com.astraeus.game.world.entity.mob.Animation;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.update.PlayerUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players animation state.
 * 
 * @author SeVen
 */
public class PlayerAnimationUpdateBlock extends PlayerUpdateBlock {

  /**
   * Creates a new {@link PlayerAnimationUpdateBlock}.
   */
  public PlayerAnimationUpdateBlock() {
    super(0x8, UpdateFlag.ANIMATION);
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    final Animation animation = entity.getAnimation();
    builder.writeShort(animation.getId(), ByteOrder.LITTLE).write(animation.getDelay(),
        ByteModification.NEGATION);
  }

}
