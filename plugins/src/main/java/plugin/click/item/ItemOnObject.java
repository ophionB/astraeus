package plugin.click.item;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ItemOnObjectEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ItemOnObjectEvent.class)
public final class ItemOnObject implements EventSubscriber<ItemOnObjectEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnObjectEvent event) {
		
	}

}
