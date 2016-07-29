package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.combat.def.AttackType;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class SwordAttackTypeButtons extends ButtonClick {

	@Override
	public void execute(Player player, ButtonActionEvent event) {
		switch(event.getButton()) {
			
		case 2282:
			player.setAttackType(AttackType.SWORD_STAB);
			break;
		
		case 2283:
			player.setAttackType(AttackType.SWORD_BLOCK);
			break;
			
		case 2284:
			player.setAttackType(AttackType.SWORD_SLASH);
			break;
			
		case 2285:
			player.setAttackType(AttackType.SWORD_LUNGE);
			break;			
		
		}

	}
	
	@Override
	public boolean test(ButtonActionEvent event) {
		if (event.getButton() == 2282 || event.getButton() == 2285 || event.getButton() == 2284 || event.getButton() == 2283) {
			return true;
		}
		
		return false;
	}

}
