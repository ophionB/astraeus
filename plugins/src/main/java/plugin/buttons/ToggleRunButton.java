package plugin.buttons;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.Movement;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public final class ToggleRunButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		case 1050:
		case 19158:
			player.attr().toggle(Movement.RUNNING_KEY);          
			
			boolean running = player.attr().get(Movement.RUNNING_KEY);
			
            // run orb toggle
            player.queuePacket(new SetWidgetConfigPacket(152, running ? 1 : 0));
            // run button in the wrench tab
            player.queuePacket(new SetWidgetConfigPacket(429, running ? 1 : 0));
			break;
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch (event.getButton()) {
		case 1050:
		case 19158:
			return true;
		}
		return false;
	}

}
