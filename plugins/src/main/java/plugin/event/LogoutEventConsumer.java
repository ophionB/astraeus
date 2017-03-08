package plugin.event;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.event.LogoutEvent;
import io.battlerune.net.packet.out.LogoutPlayerPacket;

@SubscribesTo(LogoutEvent.class)
public final class LogoutEventConsumer implements EventSubscriber<LogoutEvent> {

	@Override
	public void subscribe(EventContext context, Player player, LogoutEvent event) {		
		
		event.getPlayer().queuePacket(new LogoutPlayerPacket());
		
		event.getPlayer().resetEntityInteraction();
		
		event.getPlayer().attr().put(Player.ACTIVE_KEY, false);
		event.getPlayer().attr().put(Player.LOGOUT_KEY, true);
		event.getPlayer().attr().put(Player.DISCONNECTED_KEY, true);
	}

}
