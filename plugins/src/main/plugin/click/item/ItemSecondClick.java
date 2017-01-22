package plugin.click.item;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ItemSecondClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ItemSecondClickEvent.class)
public final class ItemSecondClick implements EventSubscriber<ItemSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemSecondClickEvent event) {
		
	}

}
