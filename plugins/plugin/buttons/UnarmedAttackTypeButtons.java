package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.combat.def.AttackType;
import astraeus.game.model.entity.mob.player.Player;

@SubscribesTo(ButtonActionEvent.class)
public final class UnarmedAttackTypeButtons extends ButtonClick {

	@Override
	public void execute(Player player, ButtonActionEvent event) {
		switch(event.getButton()) {
		
		case 5860:
			player.setAttackType(AttackType.UNARMED_PUNCH);
			break;
			
		case 5861:
			player.setAttackType(AttackType.UNARMED_BLOCK);
			break;
			
		case 5862:
			player.setAttackType(AttackType.UNARMED_KICK);
			break;
		
		}
	}
	
	@Override
	public boolean test(ButtonActionEvent event) {
		if (event.getButton() == 5860 || event.getButton() == 5861 || event.getButton() == 5862) {
			return true;
		}
		
		return false;
	}


}