package io.battlerune.net.packet.out;

import java.util.Objects;
import java.util.Optional;

import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

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
