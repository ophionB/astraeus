package plugin.click.item;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ItemOnNpcEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ItemOnNpcEvent.class)
public final class ItemOnNpc implements EventSubscriber<ItemOnNpcEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemOnNpcEvent event) {
		
	}

}
