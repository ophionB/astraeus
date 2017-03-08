package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.game.model.entity.object.GameObjects;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;
import io.battlerune.net.packet.out.AddGroundItemPacket;
import io.battlerune.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for dropping items.
 * 
 * @author Vult-R
 */
@IncomingPacketOpcode(IncomingPacket.DROP_ITEM)
public final class DropItemPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int itemId = reader.readShort(false, ByteModification.ADDITION);

    reader.readByte(false);
    reader.readByte(false);

    final int slot = reader.readShort(false, ByteModification.ADDITION);

    final Item item = player.getInventory().get(slot);

    if (item == null) {
      return;
    }

    // TODO add destoryable items
    boolean droppable = true;

    if (!droppable) {
      player.queuePacket(new ServerMessagePacket("This item cannot be dropped."));
      return;
    }

    if (player.getRights().equals(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket("ItemDropped: " + itemId));
    }

    player.queuePacket(new AddGroundItemPacket(player.getPosition().copy(), item));
    
    GameObjects.getGroundItems().put(player.getPosition().copy(), new Item[]{item});

    player.getInventory().remove(item);

  }

}
