package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ItemSecondClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_OPTION_2)
public final class ItemSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new ItemSecondClickEvent(itemId, -1));
  }

}
