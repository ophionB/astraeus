package plugin.click.obj;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.DoorEvent;
import io.battlerune.game.event.impl.ObjectFirstClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;
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
