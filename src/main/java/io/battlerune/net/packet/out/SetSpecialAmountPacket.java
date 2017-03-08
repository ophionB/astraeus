package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

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
