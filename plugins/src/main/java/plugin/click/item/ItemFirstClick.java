package plugin.click.item;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ItemFirstClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ItemFirstClickEvent.class)
public final class ItemFirstClick implements EventSubscriber<ItemFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemFirstClickEvent event) {
		
	}

}
