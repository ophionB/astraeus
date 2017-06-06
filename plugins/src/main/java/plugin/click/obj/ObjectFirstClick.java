package plugin.click.obj;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.DoorEvent;
import com.astraeus.game.event.impl.ObjectFirstClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

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
