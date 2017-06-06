package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class SetPlayerSlotPacket implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {

    GamePacketBuilder builder = new GamePacketBuilder(249);

    builder.write(1, ByteModification.ADDITION).writeShort(player.getSlot(),
        ByteModification.ADDITION, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
