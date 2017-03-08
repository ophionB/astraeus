package io.battlerune.game.model.entity.mob.player.update.mask;

import io.battlerune.game.model.Graphic;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.update.PlayerUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players graphics.
 * 
 * @author SeVen
 */
public class PlayerGraphicUpdateBlock extends PlayerUpdateBlock {

  /**
   * Creates a new {@link PlayerGraphicUpdateBlock}.
   */
  public PlayerGraphicUpdateBlock() {
    super(0x100, UpdateFlag.GRAPHICS);
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    final Graphic graphic = entity.getGraphic();
    builder.writeShort(graphic.getId(), ByteOrder.LITTLE);
    builder.writeInt(graphic.getDelay() | graphic.getHeight());
  }

}
