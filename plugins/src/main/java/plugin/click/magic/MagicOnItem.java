package plugin.click.magic;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.MagicOnItemEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(MagicOnItemEvent.class)
public final class MagicOnItem implements EventSubscriber<MagicOnItemEvent> {

	@Override
	public void subscribe(EventContext context, Player player, MagicOnItemEvent event) {
		
	}

}
