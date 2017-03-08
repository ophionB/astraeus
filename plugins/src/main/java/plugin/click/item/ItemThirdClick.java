package plugin.click.item;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ItemThirdClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ItemThirdClickEvent.class)
public final class ItemThirdClick implements EventSubscriber<ItemThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemThirdClickEvent event) {
		
	}

}
