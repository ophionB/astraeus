package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class SetSpriteColorPacket implements Sendable {

  private final int id;

  private final int color;

  public SetSpriteColorPacket(int id, int color) {
    this.id = id;
    this.color = color;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(203);
    builder.writeInt(id).writeInt(color);
    return builder.toOutgoingPacket();
  }

}
