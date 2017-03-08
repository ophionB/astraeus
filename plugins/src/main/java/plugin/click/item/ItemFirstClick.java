package plugin.click.item;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ItemFirstClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ItemFirstClickEvent.class)
public final class ItemFirstClick implements EventSubscriber<ItemFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemFirstClickEvent event) {
		
	}

}
