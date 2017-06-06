package plugin.buttons;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ButtonActionEvent;
import com.astraeus.game.world.entity.mob.player.Brightness;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public final class BrightnessButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 906:
			player.attr().put(Player.BRIGHTNESS_KEY, Brightness.VERY_DARK);
			player.queuePacket(new SetWidgetConfigPacket(166, player.attr().get(Player.BRIGHTNESS_KEY).getCode()));
			break;
			
		case 908:
			player.attr().put(Player.BRIGHTNESS_KEY, Brightness.DARK);
			player.queuePacket(new SetWidgetConfigPacket(166, player.attr().get(Player.BRIGHTNESS_KEY).getCode()));
			break;
			
		case 910:
			player.attr().put(Player.BRIGHTNESS_KEY, Brightness.NORMAL);
			player.queuePacket(new SetWidgetConfigPacket(166, player.attr().get(Player.BRIGHTNESS_KEY).getCode()));
			break;
			
		case 912:
			player.attr().put(Player.BRIGHTNESS_KEY, Brightness.BRIGHT);
			player.queuePacket(new SetWidgetConfigPacket(166, player.attr().get(Player.BRIGHTNESS_KEY).getCode()));
			break;
			
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch (event.getButton()) {
		case 906:
		case 908:
		case 910:
		case 912:
			return true;

		}
		return false;
	}

}
