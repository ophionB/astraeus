package plugin.click.item;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ItemOnNpcEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ItemOnNpcEvent.class)
public final class ItemOnNpc implements EventSubscriber<ItemOnNpcEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnNpcEvent event) {
		
	}

}
