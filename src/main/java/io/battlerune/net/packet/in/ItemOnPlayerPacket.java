package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ItemOnPlayerEvent;
import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

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
