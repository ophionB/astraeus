package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.MagicOnItemEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

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
