package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.item.ItemContainer;
import com.astraeus.game.world.entity.item.ItemContainerPolicy;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.game.world.entity.object.GameObjects;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;
import com.astraeus.net.packet.out.AddGroundItemPacket;
import com.astraeus.net.packet.out.RemoveGroundItemPacket;
import com.astraeus.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for dropping items.
 * 
 * @author Freyr
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

		final Item item = player.getInventory().get(slot).copy();

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

		player.getInventory().remove(item);

		Item[] items = GameObjects.getGroundItems().get(player.getPosition());

		ItemContainer container = new ItemContainer(64, ItemContainerPolicy.NORMAL);

		if (items == null) {
			container.add(item);
		} else {
			container.addAll(items);
			container.add(item);
		}

		GameObjects.getGroundItems().put(player.getPosition().copy(), container.container());
		
		if (item.isStackable()) {
			player.queuePacket(new RemoveGroundItemPacket(item));
		}

		player.queuePacket(new AddGroundItemPacket(player.getPosition().copy(), item));

	}

}
