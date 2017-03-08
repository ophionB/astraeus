package plugin.click.item;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ItemFirstClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ItemFirstClickEvent.class)
public final class ItemFirstClick implements EventSubscriber<ItemFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemFirstClickEvent event) {
		
	}

}
