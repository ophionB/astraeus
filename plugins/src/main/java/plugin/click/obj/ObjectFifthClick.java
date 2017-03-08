package plugin.click.obj;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ObjectFifthClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectFifthClickEvent.class)
public final class ObjectFifthClick implements EventSubscriber<ObjectFifthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFifthClickEvent event) {
		
	}

}
