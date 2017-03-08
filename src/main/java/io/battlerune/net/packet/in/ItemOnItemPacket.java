package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ItemOnItemEvent;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

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

