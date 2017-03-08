package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ItemOnNpcEvent;
import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

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

