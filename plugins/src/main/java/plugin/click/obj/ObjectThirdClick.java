package plugin.click.obj;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ObjectThirdClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectThirdClickEvent.class)
public final class ObjectThirdClick implements EventSubscriber<ObjectThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectThirdClickEvent event) {
		
	}

}
