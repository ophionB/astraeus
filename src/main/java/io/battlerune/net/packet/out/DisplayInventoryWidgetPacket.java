package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class DisplayInventoryWidgetPacket implements Sendable {

  private final int widgetId;

  private final int sidebarId;

  public DisplayInventoryWidgetPacket(int widgetId, int sidebarId) {

    this.widgetId = widgetId;
    this.sidebarId = sidebarId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(248);
    builder.writeShort(widgetId, ByteModification.ADDITION).writeShort(sidebarId);
    return builder.toOutgoingPacket();
  }

}
