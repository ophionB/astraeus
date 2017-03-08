package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

/**
 * The packet responsible for removing ground items.
 *
 * @author Vult-R
 */
public final class RemoveGroundItemPacket implements Sendable {

  private final Item item;

  public RemoveGroundItemPacket(Item item) {
    this.item = item;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    final GamePacketBuilder builder = new GamePacketBuilder(156);
    builder.write(0, ByteModification.SUBTRACTION).writeShort(item.getId());
    return builder.toOutgoingPacket();
  }

}
