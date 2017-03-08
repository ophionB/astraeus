package plugin.click.obj;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ObjectFourthClickEvent;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectFourthClickEvent.class)
public final class ObjectFourthClick implements EventSubscriber<ObjectFourthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFourthClickEvent event) {
		
	}

}
