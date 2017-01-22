package plugin.click.obj;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ObjectFifthClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectFifthClickEvent.class)
public final class ObjectFifthClick implements EventSubscriber<ObjectFifthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFifthClickEvent event) {
		
	}

}
