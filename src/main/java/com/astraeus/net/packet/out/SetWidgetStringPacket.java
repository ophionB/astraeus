package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.PacketHeader;
import com.astraeus.net.packet.Sendable;

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
