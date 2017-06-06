package plugin.click.magic;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.MagicOnItemEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(MagicOnItemEvent.class)
public final class MagicOnItem implements EventSubscriber<MagicOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, MagicOnItemEvent event) {
		
	}

}
