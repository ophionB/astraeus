package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_5)
public final class WidgetContainerFifthOptionPacket implements Receivable {

  @SuppressWarnings("unused")
  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int itemSlot = reader.readShort(ByteOrder.LITTLE);
    int interfaceId = reader.readShort(ByteModification.ADDITION);
    int itemId = reader.readShort(ByteOrder.LITTLE);
  }

}
