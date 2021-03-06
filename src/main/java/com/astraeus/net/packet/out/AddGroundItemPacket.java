package com.astraeus.net.packet.out;

import java.util.Objects;
import java.util.Optional;

import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

/**
 * The {@link Sendable} implementation that displays an item on the ground.
 * 
 * @author Vult-R
 */
public final class AddGroundItemPacket implements Sendable {

  private final Position position;
  
  private final Item item;

  public AddGroundItemPacket(Position position, Item item) {
    this.position = Objects.requireNonNull(position);
    this.item = Objects.requireNonNull(item);
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    player.queuePacket(new SetUpdateRegionPacket(position));
    
    final GamePacketBuilder builder = new GamePacketBuilder(44);
    builder.writeShort(item.getId(), ByteModification.ADDITION, ByteOrder.LITTLE)
        .writeShort(item.getAmount()).write(0); // offset
    return builder.toOutgoingPacket();
  }

}
