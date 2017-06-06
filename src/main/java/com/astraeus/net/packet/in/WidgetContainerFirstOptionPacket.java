package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.WidgetContainerFirstOptionEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_1)
public final class WidgetContainerFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();

    final int widgetId = reader.readShort(ByteModification.ADDITION);
    final int itemSlot = reader.readShort(ByteModification.ADDITION);
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new WidgetContainerFirstOptionEvent(widgetId, itemId, itemSlot));
  }

}
