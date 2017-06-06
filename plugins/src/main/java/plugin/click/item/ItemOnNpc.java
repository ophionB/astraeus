package plugin.click.item;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ItemOnNpcEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ItemOnNpcEvent.class)
public final class ItemOnNpc implements EventSubscriber<ItemOnNpcEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnNpcEvent event) {
		
	}

}
