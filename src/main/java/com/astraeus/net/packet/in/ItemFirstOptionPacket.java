package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ItemFirstClickEvent;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_OPTION_1)
public final class ItemFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int widgetId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int slot = reader.readShort(false, ByteModification.ADDITION);
    final int id = reader.readShort(ByteOrder.LITTLE);

    final Item item = player.getInventory().get(slot);

    if (item.getId() != id) {
      return;
    }

    player.post(new ItemFirstClickEvent(item, widgetId));
  }

}
