package plugin.buttons;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.ButtonActionEvent;
import com.astraeus.game.world.entity.mob.combat.def.AttackType;
import com.astraeus.game.world.entity.mob.player.Player;

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
