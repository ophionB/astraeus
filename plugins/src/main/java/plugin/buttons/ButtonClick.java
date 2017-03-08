package plugin.buttons;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.player.Player;

public abstract class ButtonClick implements EventSubscriber<ButtonActionEvent> {

	@Override
	public void subscribe(EventContext context, Player player, ButtonActionEvent event) {
		execute(player, event);
	}
	
	protected abstract void execute(Player player, ButtonActionEvent event);
	
	public abstract boolean test(ButtonActionEvent event);

}
