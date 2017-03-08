package plugin.click.item;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ItemOnItemEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ItemOnItemEvent.class)
public final class ItemOnItem implements EventSubscriber<ItemOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnItemEvent event) {
		
	}

}
