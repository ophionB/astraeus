package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.packet.out.SetWidgetConfigPacket;

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
