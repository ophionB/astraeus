package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class UpdateMapRegion implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(73);
    player.setLastPosition(player.getPosition().copy());
    builder.writeShort(player.getPosition().getRegionalX() + 6, ByteModification.ADDITION)
        .writeShort(player.getPosition().getRegionalY() + 6);
    return builder.toOutgoingPacket();
  }

}
