package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.combat.dmg.Poison.PoisonType;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

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
