package plugin.doors;

import java.util.ArrayList;
import java.util.List;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.DoorEvent;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(DoorEvent.class)
public final class Doors implements EventSubscriber<DoorEvent> {

	/**
	 * The list of door objects spawned in the game world.
	 */
	private static final List<Door> doors = new ArrayList<>();
	
	static {
		new DoorParser().run();
	}

	@Override
	public void subscribe(EventContext context, Player player, DoorEvent event) {
		DoorUtils.handleDoor(player, event.getDoor());		
	}
	
	public static List<Door> getDoors() {
		return doors;
	}

}
