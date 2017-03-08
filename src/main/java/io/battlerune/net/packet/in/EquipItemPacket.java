package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for equipping items.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.EQUIP_ITEM)
public final class EquipItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int id = reader.readShort();
    final int slot = reader.readShort(ByteModification.ADDITION);
    final int interfaceId = reader.readShort(ByteModification.ADDITION);

    if (player.getRights().greaterOrEqual(PlayerRights.DEVELOPER)
        && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket(String
          .format("[EquipItem] - [id= %d], [slot= %d], [interfaceId= %d]", id, slot, interfaceId)));
    }

    Item item = player.getInventory().get(slot);

    if (item == null || item.getId() != id) {
      return;
    }

    if (interfaceId == 3214) {
      player.getEquipment().equip(slot);
    }

  }
}
