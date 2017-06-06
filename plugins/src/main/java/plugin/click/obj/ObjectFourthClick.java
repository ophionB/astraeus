package plugin.click.obj;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ObjectFourthClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectFourthClickEvent.class)
public final class ObjectFourthClick implements EventSubscriber<ObjectFourthClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectFourthClickEvent event) {
		
	}

}
