package plugin.click.widget;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.WidgetContainerFourthOptionEvent;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.item.ItemDefinition;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.packet.out.ServerMessagePacket;

import plugin.shops.Shops;

@SubscribesTo(WidgetContainerFourthOptionEvent.class)
public final class WidgetContainerFourthClick implements EventSubscriber<WidgetContainerFourthOptionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, WidgetContainerFourthOptionEvent event) {
		if (player.getRights().equal(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
			player.queuePacket(new ServerMessagePacket("[WidgetContainerFourthOption] widgetId: " + event.getWidgetId()
					+ " id: " + event.getItemId() + " slot: " + event.getItemSlot()));
		}

		switch (event.getWidgetId()) {

		case 3823:
        	Shops.search(player).ifPresent(it -> it.sell(player, new Item(event.getItemId(), 10), event.getItemSlot()));
			break;

		case 3900:
			Shops.search(player).ifPresent(it -> it.purchase(player, new Item(event.getItemId(), 10)));
			break;

		case 5064:
			player.getBank().depositFromInventory(event.getItemSlot(), player.getInventory().amount(player.getInventory().getId(event.getItemSlot())));
			break;

		case 5382:
            int amount = 0;
            if (player.isWithdrawAsNote()) {
                amount = player.getBank().amount(event.getItemId());
            } else {
                Item itemWithdrew = new Item(event.getItemId(), 1);
                amount = ItemDefinition.lookup(itemWithdrew.getId()).isStackable() ? player.getBank().amount(event.getItemId()) : 28;
            }

            player.getBank().withdraw(event.getItemSlot(), amount, true);
			break;

		}
	}

}
