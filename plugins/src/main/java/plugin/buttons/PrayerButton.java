package plugin.buttons;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ButtonActionEvent;
import com.astraeus.game.world.entity.mob.combat.CombatPrayer;
import com.astraeus.game.world.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class PrayerButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		player.getCombatPrayer().clickButton(event.getButton());
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		return CombatPrayer.isPrayerButton(event.getButton());
	}

}
