package plugin.buttons;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class LogoutButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 2458:
			player.logout();
			break;
		
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return event.getButton() == 2458;
	}

}
