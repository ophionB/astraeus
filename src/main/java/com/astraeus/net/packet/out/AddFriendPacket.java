package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class AddFriendPacket implements Sendable {

  private final long username;

  private int world;

  public AddFriendPacket(long username, int world) {
    this.username = username;
    this.world = world;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(50);

    builder.writeLong(username);
    builder.write(world + 1);
    return builder.toOutgoingPacket();
  }

}
