package plugin.click.obj;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ObjectSecondClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectSecondClickEvent.class)
public final class ObjectSecondClick implements EventSubscriber<ObjectSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectSecondClickEvent event) {
		
	}

}
