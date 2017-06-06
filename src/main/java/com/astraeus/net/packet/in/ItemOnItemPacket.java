package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ItemOnItemEvent;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_ITEM)
public final class ItemOnItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int usedWithSlot = reader.readShort();
    final int itemUsedSlot = reader.readShort(ByteModification.ADDITION);

    final Item used = player.getInventory().get(itemUsedSlot);

    final Item with = player.getInventory().get(usedWithSlot);

    player.post(new ItemOnItemEvent(used, with));
  }

}

