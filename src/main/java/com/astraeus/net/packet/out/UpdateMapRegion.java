package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

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
