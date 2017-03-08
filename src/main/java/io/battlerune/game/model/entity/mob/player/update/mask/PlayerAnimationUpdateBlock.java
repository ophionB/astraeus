package io.battlerune.game.model.entity.mob.player.update.mask;

import io.battlerune.game.model.Animation;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.update.PlayerUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;

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
