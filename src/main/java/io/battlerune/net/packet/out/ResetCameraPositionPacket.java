package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class ResetCameraPositionPacket implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    return new GamePacketBuilder(107).toOutgoingPacket();
  }

}
