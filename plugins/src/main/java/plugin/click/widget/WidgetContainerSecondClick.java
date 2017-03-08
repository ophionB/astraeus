package plugin.click.widget;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.WidgetContainerSecondOptionEvent;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.packet.out.ServerMessagePacket;
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
