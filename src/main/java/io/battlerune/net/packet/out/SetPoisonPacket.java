package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.combat.dmg.Poison.PoisonType;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class SetPoisonPacket implements Sendable {

  /**
   * The type of poison.
   */
  private final PoisonType type;

  /**
   * The type of poison.
   */
  public SetPoisonPacket(PoisonType type) {
    this.type = type;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder();
    builder.write(type.getType(), ByteModification.NEGATION);
    return builder.toOutgoingPacket();
  }

}
