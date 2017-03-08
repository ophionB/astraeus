package plugin.click.obj;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ObjectSecondClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectSecondClickEvent.class)
public final class ObjectSecondClick implements EventSubscriber<ObjectSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectSecondClickEvent event) {
		
	}

}
