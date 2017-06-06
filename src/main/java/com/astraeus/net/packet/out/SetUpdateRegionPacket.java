package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class SetUpdateRegionPacket implements Sendable {

  private final Position position;

  public SetUpdateRegionPacket(Position position) {
    this.position = position;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(85);
    builder
        .write((position.getY() - 8 * player.getLastPosition().getRegionalY()),
            ByteModification.NEGATION)
        .write((position.getX() - 8 * player.getLastPosition().getRegionalX()),
            ByteModification.NEGATION);
    return builder.toOutgoingPacket();
  }

}
