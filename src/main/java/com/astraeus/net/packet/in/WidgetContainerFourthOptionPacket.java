package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.WidgetContainerFourthOptionEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_4)
public final class WidgetContainerFourthOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int itemSlot = reader.readShort(ByteModification.ADDITION);
    final int widgetId = reader.readShort();
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new WidgetContainerFourthOptionEvent(widgetId, itemId, itemSlot));
  }

}
