package plugin.click.widget;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.WidgetContainerThirdOptionEvent;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.packet.out.ServerMessagePacket;

import plugin.shops.Shops;

@SubscribesTo(WidgetContainerThirdOptionEvent.class)
public final class WidgetContainerThirdClick implements EventSubscriber<WidgetContainerThirdOptionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, WidgetContainerThirdOptionEvent event) {
		if (player.getRights().equal(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
			player.queuePacket(new ServerMessagePacket("[WidgetContainerThirdClick] widgetId: " + event.getWidgetId()
					+ " id: " + event.getItemId() + " slot: " + event.getItemSlot()));
		}

		switch (event.getWidgetId()) {
		
        case 3823:
        	Shops.search(player).ifPresent(it -> it.sell(player, new Item(event.getItemId(), 5), event.getItemSlot()));
            break;
		
        case 3900:
            Shops.search(player).ifPresent(it -> it.purchase(player, new Item(event.getItemId(), 5)));
            break;

		case 5064:
			player.getBank().depositFromInventory(event.getItemSlot(), 10);
			break;

		case 5382:
			player.getBank().withdraw(event.getItemSlot(), 10, true);
			break;

		}
	}

}
