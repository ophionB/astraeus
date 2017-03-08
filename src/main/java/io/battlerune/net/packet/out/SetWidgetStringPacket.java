package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.PacketHeader;
import io.battlerune.net.packet.Sendable;

public final class SetWidgetStringPacket implements Sendable {

  private final String string;

  private final int id;

  public SetWidgetStringPacket(String string, int id) {
    this.string = string;
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(126, PacketHeader.VARIABLE_SHORT);
    builder.writeString(string).writeShort(id, ByteModification.ADDITION);
    return builder.toOutgoingPacket();
  }
}
