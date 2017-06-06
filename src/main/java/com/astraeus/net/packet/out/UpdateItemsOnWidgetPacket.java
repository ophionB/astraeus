package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.PacketHeader;
import com.astraeus.net.packet.Sendable;

public final class UpdateItemsOnWidgetPacket implements Sendable {

  private final int id;

  private final Item[] items;

  public UpdateItemsOnWidgetPacket(int id, Item... items) {
    this.id = id;
    this.items = items;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(53, PacketHeader.VARIABLE_SHORT);
    builder.writeShort(id);

    if (items == null) {
      builder.writeShort(0).write(0).writeShort(0, ByteModification.ADDITION, ByteOrder.LITTLE);
      return builder.toOutgoingPacket();
    }

    builder.writeShort(items.length);

    for (final Item item : items) {
      if (item != null) {
        if (item.getAmount() > 254) {
          builder.write(255).writeInt(item.getAmount(), ByteOrder.INVERSE_MIDDLE);
        } else {
          builder.write(item.getAmount());
        }
        builder.writeShort(item.getId() + 1, ByteModification.ADDITION, ByteOrder.LITTLE);
      } else {
        builder.write(0).writeShort(0, ByteModification.ADDITION, ByteOrder.LITTLE);
      }
    }
    return builder.toOutgoingPacket();
  }

}
