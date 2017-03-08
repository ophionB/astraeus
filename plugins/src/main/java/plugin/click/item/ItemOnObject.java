package plugin.click.item;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ItemOnObjectEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ItemOnObjectEvent.class)
public final class ItemOnObject implements EventSubscriber<ItemOnObjectEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnObjectEvent event) {
		
	}

}
