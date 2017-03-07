package plugin.click.obj;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.DoorEvent;
import astraeus.game.event.impl.ObjectFirstClickEvent;
import astraeus.game.model.entity.mob.player.Player;
import plugin.doors.DoorUtils;

@SubscribesTo(ObjectFirstClickEvent.class)
public final class ObjectFirstClick implements EventSubscriber<ObjectFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFirstClickEvent event) {
		if (DoorUtils.isDoor(event.getGameObject().getId())) {
			player.post(new DoorEvent(event.getGameObject()));
			return;
		}
		
		switch (event.getGameObject().getId()) {
		
		case 2213:
			player.getBank().open();
			break;
		
		}
		
	}

}
