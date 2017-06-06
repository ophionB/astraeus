package plugin.click.item;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ItemThirdClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ItemThirdClickEvent.class)
public final class ItemThirdClick implements EventSubscriber<ItemThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ItemThirdClickEvent event) {
		
	}

}
