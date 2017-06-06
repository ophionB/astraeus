package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

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
