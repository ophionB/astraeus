package plugin.click.obj;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ObjectSecondClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectSecondClickEvent.class)
public final class ObjectSecondClick implements EventSubscriber<ObjectSecondClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectSecondClickEvent event) {
		
	}

}
