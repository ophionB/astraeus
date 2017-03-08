package io.battlerune.game.model.entity.mob.player.update.mask;

import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.update.PlayerUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;

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
