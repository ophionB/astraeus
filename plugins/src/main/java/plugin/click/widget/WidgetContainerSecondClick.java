package plugin.click.widget;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.WidgetContainerSecondOptionEvent;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.packet.out.ServerMessagePacket;

import plugin.shops.Shops;

@SubscribesTo(WidgetContainerSecondOptionEvent.class)
public final class WidgetContainerSecondClick implements EventSubscriber<WidgetContainerSecondOptionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, WidgetContainerSecondOptionEvent event) {

		if (player.getRights().equal(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
			player.queuePacket(new ServerMessagePacket("[WidgetContainerSecondClick] widgetId: " + event.getWidgetId() + " itemId: " + event.getItemId() + " slot: " + event.getItemSlot()));
		}
		
		switch (event.getWidgetId()) {
		
        case 3823:
        	Shops.search(player).ifPresent(it -> it.sell(player, new Item(event.getItemId(), 1), event.getItemSlot()));
            break;
		
        case 3900:
            Shops.search(player).ifPresent(it -> it.purchase(player, new Item(event.getItemId(), 1)));            
            break;

		case 5064:
			player.getBank().depositFromInventory(event.getItemSlot(), 5);
			break;

		case 5382:
			player.getBank().withdraw(event.getItemSlot(), 5, true);
			break;

		}
	}

}
