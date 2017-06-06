package plugin.buttons;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.impl.ButtonActionEvent;
import com.astraeus.game.world.entity.mob.player.Player;

public abstract class ButtonClick implements EventSubscriber<ButtonActionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ButtonActionEvent event) {
		execute(player, event);
	}
	
	protected abstract void execute(Player player, ButtonActionEvent event);
	
	public abstract boolean test(ButtonActionEvent event);

}
