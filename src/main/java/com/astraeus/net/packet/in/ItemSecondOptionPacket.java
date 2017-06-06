package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ItemSecondClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_OPTION_2)
public final class ItemSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final ByteBufReader reader = packet.getReader();
    final int itemId = reader.readShort(ByteModification.ADDITION);

    player.post(new ItemSecondClickEvent(itemId, -1));
  }

}
