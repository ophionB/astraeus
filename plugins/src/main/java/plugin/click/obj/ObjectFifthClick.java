package plugin.click.obj;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ObjectFifthClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectFifthClickEvent.class)
public final class ObjectFifthClick implements EventSubscriber<ObjectFifthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFifthClickEvent event) {
		
	}

}
