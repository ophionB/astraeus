package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class SetWidgetAnimationPacket implements Sendable {

  private final int interfaceId;

  private final int animationId;

  public SetWidgetAnimationPacket(int interfaceId, int animationId) {
    this.interfaceId = interfaceId;
    this.animationId = animationId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(200);
    builder.writeShort(interfaceId).writeShort(animationId);
    return builder.toOutgoingPacket();
  }

}
