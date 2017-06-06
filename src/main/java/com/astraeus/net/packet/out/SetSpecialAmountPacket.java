package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class SetSpecialAmountPacket implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(137);

    if (player.getSpecialAmount() > 100) {
      player.setSpecialAmount(100);
    }

    if (player.getSpecialAmount() < 0) {
      player.setSpecialAmount(0);
    }

    builder.write(player.getSpecialAmount());
    return builder.toOutgoingPacket();
  }
}
