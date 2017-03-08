package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.WidgetContainerSecondOptionEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;

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
