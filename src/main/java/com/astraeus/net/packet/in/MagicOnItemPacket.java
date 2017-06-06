package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.MagicOnItemEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for using magic on inventory items.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.MAGIC_ON_ITEMS)
public final class MagicOnItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int slot = reader.readShort();
    final int itemId = reader.readShort(ByteModification.ADDITION);
    final int childId = reader.readShort();
    final int spellId = reader.readShort(ByteModification.ADDITION);

    player.post(new MagicOnItemEvent(itemId, slot, childId, spellId));
  }

}
