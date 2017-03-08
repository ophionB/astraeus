package plugin.click.obj;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ObjectThirdClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectThirdClickEvent.class)
public final class ObjectThirdClick implements EventSubscriber<ObjectThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectThirdClickEvent event) {
		
	}

}
