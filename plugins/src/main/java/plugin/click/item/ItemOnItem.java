package plugin.click.item;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ItemOnItemEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ItemOnItemEvent.class)
public final class ItemOnItem implements EventSubscriber<ItemOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnItemEvent event) {
		
	}

}
