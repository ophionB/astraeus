package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ItemOnObjectEvent;
import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.object.GameObject;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ITEM_ON_OBJECT)
public final class ItemOnObjectPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    @SuppressWarnings("unused")
    int interfaceType = reader.readShort();
    final int objectId = reader.readShort(ByteOrder.LITTLE);
    final int objectY = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int slot = reader.readShort(ByteOrder.LITTLE);
    final int objectX = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final int itemId = reader.readShort();

    final Item item = player.getInventory().get(slot);

    // validate the item exists and is the correct item
    if (item.getId() != itemId) {
      return;
    }

    // instead of doing it this way, when clipping gets added grab the game object from a map of
    // objects
    GameObject object = new GameObject(objectId, new Position(objectX, objectY));

    player.post(new ItemOnObjectEvent(item, object));
  }

}

