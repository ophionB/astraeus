package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.combat.CombatPrayer;
import astraeus.game.model.entity.mob.player.Player;

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
