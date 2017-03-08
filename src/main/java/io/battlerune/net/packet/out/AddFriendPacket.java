package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

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
