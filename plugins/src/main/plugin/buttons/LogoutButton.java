package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.player.Player;

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
