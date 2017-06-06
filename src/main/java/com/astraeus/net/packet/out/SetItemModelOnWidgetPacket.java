package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class SetItemModelOnWidgetPacket implements Sendable {

  private final int id;

  private final int zoom;

  private final int model;

  public SetItemModelOnWidgetPacket(int id, int zoom, int model) {
    this.id = id;
    this.zoom = zoom;
    this.model = model;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(246);
    builder.writeShort(id, ByteOrder.LITTLE).writeShort(zoom).writeShort(model);
    return builder.toOutgoingPacket();
  }

}
