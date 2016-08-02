package plugin.click.magic;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.MagicOnItemEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(MagicOnItemEvent.class)
public final class MagicOnItem implements EventSubscriber<MagicOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, MagicOnItemEvent event) {
		
	}

}
