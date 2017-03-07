package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.combat.def.AttackType;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class WhipAttackTypeWidgetButtons extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 12296:
			player.setAttackType(AttackType.WHIP_DEFLECT);
			break;
			
		case 12297:
			player.setAttackType(AttackType.WHIP_LASH);
			break;
			
		case 12298:
			player.setAttackType(AttackType.WHIP_FLICK);
			break;
			
		}

	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 12296:
		case 12297:
		case 12298:
			return true;
		
		}
		
		return false;
	}

}
