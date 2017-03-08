package plugin.click.item;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ItemThirdClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ItemThirdClickEvent.class)
public final class ItemThirdClick implements EventSubscriber<ItemThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemThirdClickEvent event) {
		
	}

}
