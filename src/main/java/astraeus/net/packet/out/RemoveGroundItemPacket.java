package astraeus.net.packet.out;

import java.util.Optional;

import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.codec.ByteModification;
import astraeus.net.codec.game.GamePacketBuilder;
import astraeus.net.packet.OutgoingPacket;
import astraeus.net.packet.Sendable;

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
