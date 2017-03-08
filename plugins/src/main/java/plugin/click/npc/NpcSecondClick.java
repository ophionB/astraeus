package plugin.click.npc;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.NpcSecondClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(NpcSecondClickEvent.class)
public final class NpcSecondClick implements EventSubscriber<NpcSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcSecondClickEvent event) {
		
	}

}
