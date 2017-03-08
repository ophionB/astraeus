package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class DisplayWalkableWidgetPacket implements Sendable {

  private final int id;

  public DisplayWalkableWidgetPacket(int id) {
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(208);
    builder.writeShort(id, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
