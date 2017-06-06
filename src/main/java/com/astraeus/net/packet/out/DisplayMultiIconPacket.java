package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class DisplayMultiIconPacket implements Sendable {

  private final boolean hide;

  public DisplayMultiIconPacket(boolean hide) {
    this.hide = hide;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(61);
    builder.write(hide ? 0 : 1);
    return builder.toOutgoingPacket();
  }

}
