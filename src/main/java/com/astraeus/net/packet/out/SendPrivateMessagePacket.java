package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.PacketHeader;
import com.astraeus.net.packet.Sendable;

public final class SendPrivateMessagePacket implements Sendable {

  private final long name;

  private final PlayerRights rights;

  private final byte[] message;

  private final int size;

  public SendPrivateMessagePacket(long name, PlayerRights rights, byte[] message, int size) {
    this.name = name;
    this.rights = rights;
    this.message = message;
    this.size = size;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(196, PacketHeader.VARIABLE_BYTE);
    builder.writeLong(name).writeInt(player.lastMessage++).write(rights.getProtocolValue())
        .writeBytes(message, size);
    return builder.toOutgoingPacket();
  }

}
