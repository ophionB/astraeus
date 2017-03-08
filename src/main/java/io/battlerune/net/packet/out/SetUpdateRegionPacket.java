package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

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
