package plugin.click.npc;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.NpcSecondClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(NpcSecondClickEvent.class)
public final class NpcSecondClick implements EventSubscriber<NpcSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcSecondClickEvent event) {
		
	}

}
