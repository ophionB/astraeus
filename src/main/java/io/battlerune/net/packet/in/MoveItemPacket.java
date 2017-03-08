package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for moving player items in inventory.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.MOVE_ITEM)
public class MoveItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int interfaceId = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    @SuppressWarnings("unused")
    final int inserting = reader.readByte(ByteModification.NEGATION);
    final int fromSlot = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int toSlot = reader.readShort(ByteOrder.LITTLE);

    switch (interfaceId) {

      case 3214:
        player.getInventory().swap(fromSlot, toSlot);
        player.getInventory().refresh();
        break;

      case 5382:
        if (player.isInsertItem()) {
          player.getBank().swap(fromSlot, toSlot);
        } else {
          player.getBank().transfer(fromSlot, toSlot);
        }
        player.getBank().refresh();
        break;

      default:
        System.out.println("Unkown Item movement interface id: " + interfaceId);
        break;
    }
  }
}