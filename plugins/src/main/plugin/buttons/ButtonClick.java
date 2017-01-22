package plugin.buttons;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.player.Player;

public abstract class ButtonClick implements EventSubscriber<ButtonActionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ButtonActionEvent event) {
		execute(player, event);
	}
	
	protected abstract void execute(Player player, ButtonActionEvent event);
	
	public abstract boolean test(ButtonActionEvent event);

}
