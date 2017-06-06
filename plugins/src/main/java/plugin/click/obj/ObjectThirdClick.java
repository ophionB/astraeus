package plugin.click.obj;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ObjectThirdClickEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ObjectThirdClickEvent.class)
public final class ObjectThirdClick implements EventSubscriber<ObjectThirdClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ObjectThirdClickEvent event) {
		
	}

}
