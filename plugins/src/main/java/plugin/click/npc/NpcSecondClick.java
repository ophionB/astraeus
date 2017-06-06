package plugin.click.npc;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.NpcSecondClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(NpcSecondClickEvent.class)
public final class NpcSecondClick implements EventSubscriber<NpcSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcSecondClickEvent event) {
		
	}

}
