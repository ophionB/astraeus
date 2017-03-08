package plugin.click.npc;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.NpcThirdClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(NpcThirdClickEvent.class)
public final class NpcThirdClick implements EventSubscriber<NpcThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcThirdClickEvent event) {
		
	}

}
