package plugin.click.item;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ItemOnObjectEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ItemOnObjectEvent.class)
public final class ItemOnObject implements EventSubscriber<ItemOnObjectEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnObjectEvent event) {
		
	}

}
