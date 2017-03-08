package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class DisplayPlayerHeadModelOnWidgetPacket implements Sendable {

  private final int interfaceId;

  public DisplayPlayerHeadModelOnWidgetPacket(int interfaceId) {
    this.interfaceId = interfaceId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(185);
    builder.writeShort(interfaceId, ByteModification.ADDITION, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
