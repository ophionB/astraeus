package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class SetSideBarWidgetPacket implements Sendable {

  private final int tabId;

  private final int interfaceId;

  public SetSideBarWidgetPacket(int tabId, int interfaceId) {
    this.tabId = tabId;
    this.interfaceId = interfaceId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(71);
    builder.writeShort(interfaceId).write(tabId, ByteModification.ADDITION);
    return builder.toOutgoingPacket();
  }

}
