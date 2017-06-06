package plugin.click.npc;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.NpcThirdClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(NpcThirdClickEvent.class)
public final class NpcThirdClick implements EventSubscriber<NpcThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcThirdClickEvent event) {
		
	}

}
