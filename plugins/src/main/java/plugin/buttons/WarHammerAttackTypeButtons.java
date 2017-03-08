package plugin.buttons;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.combat.def.AttackType;
import io.battlerune.game.model.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class WarHammerAttackTypeButtons extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 431:
			player.setAttackType(AttackType.WARHAMMER_BLOCK);
			break;
			
		case 432:
			player.setAttackType(AttackType.WARHAMMER_PUMMEL);
			break;
			
		case 433:
			player.setAttackType(AttackType.WARHAMMER_POUND);
			break;
		
		}
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch (event.getButton()) {		
		case 431:
		case 432:
		case 433:
			return true;			
		}		
		 return false;
	}

}
