package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class SetWidgetColorPacket implements Sendable {

  private final int id;

  private final int color;

  public SetWidgetColorPacket(int id, int color) {
    this.id = id;
    this.color = color;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(122);
    builder.writeShort(id, ByteModification.ADDITION, ByteOrder.LITTLE).writeShort(color,
        ByteModification.ADDITION, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
