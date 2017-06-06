package plugin.click.item;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ItemSecondClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ItemSecondClickEvent.class)
public final class ItemSecondClick implements EventSubscriber<ItemSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemSecondClickEvent event) {
		
	}

}
