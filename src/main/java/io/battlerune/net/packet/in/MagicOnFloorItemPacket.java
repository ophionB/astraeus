package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for using magic on ground items.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(181)
public class MagicOnFloorItemPacket implements Receivable {

  @SuppressWarnings("unused")
  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int itemY = reader.readShort(ByteOrder.LITTLE);
    final int itemId = reader.readShort(false);
    final int itemX = reader.readShort(ByteOrder.LITTLE);
    final int spellId = reader.readShort(false, ByteModification.ADDITION);

  }

}
