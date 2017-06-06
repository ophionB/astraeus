package plugin.buttons;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ButtonActionEvent;
import com.astraeus.game.world.entity.mob.player.Player;

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
