package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class ForceTabWidgetPacket implements Sendable {

  private final int id;

  public ForceTabWidgetPacket(int id) {
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(106);
    builder.write(id, ByteModification.NEGATION);
    player.getUpdateFlags().add(UpdateFlag.APPEARANCE);
    return builder.toOutgoingPacket();
  }

}
