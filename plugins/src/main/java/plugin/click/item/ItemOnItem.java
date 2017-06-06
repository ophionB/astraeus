package plugin.click.item;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ItemOnItemEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ItemOnItemEvent.class)
public final class ItemOnItem implements EventSubscriber<ItemOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnItemEvent event) {
		
	}

}
