package plugin.click.npc;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.NpcThirdClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(NpcThirdClickEvent.class)
public final class NpcThirdClick implements EventSubscriber<NpcThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcThirdClickEvent event) {
		
	}

}
