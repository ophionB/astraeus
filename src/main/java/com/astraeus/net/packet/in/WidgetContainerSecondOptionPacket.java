package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.WidgetContainerSecondOptionEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_2)
public final class WidgetContainerSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int widgetId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int itemId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int itemSlot = reader.readShort(ByteOrder.LITTLE);

    player.post(new WidgetContainerSecondOptionEvent(widgetId, itemId, itemSlot));
  }

}
