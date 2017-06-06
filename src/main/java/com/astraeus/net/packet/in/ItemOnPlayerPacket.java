package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ItemOnPlayerEvent;
import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_PLAYER)
public final class ItemOnPlayerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final int playerIndex = packet.getReader().readShort(false);
    final int itemSlot = packet.getReader().readShort(ByteOrder.LITTLE);

    final Item used = player.getInventory().get(itemSlot);

    final Player usedWith = World.getPlayers().get(playerIndex);

    player.post(new ItemOnPlayerEvent(used, usedWith));

  }

}
