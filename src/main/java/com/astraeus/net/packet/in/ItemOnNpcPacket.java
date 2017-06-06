package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ItemOnNpcEvent;
import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_NPC)
public final class ItemOnNpcPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int itemId = reader.readShort(false, ByteModification.ADDITION);
    final int npcSlot = reader.readShort(false, ByteModification.ADDITION);
    final int itemSlot = reader.readShort(ByteOrder.LITTLE);

    final Item item = player.getInventory().get(itemSlot);

    // validate the item is the correct item
    if (item.getId() != itemId) {
      return;
    }

    final Npc npc = World.getNpcs().get(npcSlot);

    // validate the npc actually exists
    if (npc == null) {
      return;
    }

    player.post(new ItemOnNpcEvent(item, npc));
  }

}

