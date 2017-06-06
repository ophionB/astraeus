package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

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
