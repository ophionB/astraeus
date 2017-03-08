package plugin.click.obj;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ObjectFourthClickEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ObjectFourthClickEvent.class)
public final class ObjectFourthClick implements EventSubscriber<ObjectFourthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFourthClickEvent event) {
		
	}

}
