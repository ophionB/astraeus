package plugin.buttons;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public class ToggleSplitChatButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 957:
	        player.attr().toggle(Player.SPLIT_CHAT_KEY);
	        player.queuePacket(new SetWidgetConfigPacket(287, player.attr().get(Player.SPLIT_CHAT_KEY)));
			break;
		
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return event.getButton() == 957;
	}

}
