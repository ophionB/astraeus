package plugin.click.item;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ItemSecondClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ItemSecondClickEvent.class)
public final class ItemSecondClick implements EventSubscriber<ItemSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemSecondClickEvent event) {
		
	}

}
