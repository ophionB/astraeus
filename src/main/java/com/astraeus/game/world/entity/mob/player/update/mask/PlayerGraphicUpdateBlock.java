package com.astraeus.game.world.entity.mob.player.update.mask;

import com.astraeus.game.world.entity.Graphic;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.update.PlayerUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;

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
