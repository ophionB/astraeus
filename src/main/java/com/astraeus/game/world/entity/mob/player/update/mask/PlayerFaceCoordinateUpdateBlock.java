package com.astraeus.game.world.entity.mob.player.update.mask;

import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.update.PlayerUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players facing direction.
 * 
 * @author SeVen
 */
public class PlayerFaceCoordinateUpdateBlock extends PlayerUpdateBlock {

  /**
   * Creates a new {@link PlayerFaceCoordinateUpdateBlock}.
   */
  public PlayerFaceCoordinateUpdateBlock() {
    super(0x2, UpdateFlag.FACE_COORDINATE);
  }

  @Override
  public void encode(Player target, GamePacketBuilder builder) {
    final Position location = target.getFacingLocation();
    int x = location == null ? 0 : location.getX();
    int y = location == null ? 0 : location.getY();
    builder.writeShort(x * 2 + 1, ByteModification.ADDITION, ByteOrder.LITTLE).writeShort(y * 2 + 1,
        ByteOrder.LITTLE);
  }

}
