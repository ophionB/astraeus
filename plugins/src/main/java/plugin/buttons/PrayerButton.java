package plugin.buttons;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.combat.CombatPrayer;
import io.battlerune.game.model.entity.mob.player.Player;

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
