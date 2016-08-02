package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.combat.def.AttackType
import astraeus.game.model.entity.mob.player.Player

@SubscribesTo(ButtonActionEvent::class)
class WarHammerAttackTypeButtons : ButtonClick() {

	override fun execute(player: Player, event: ButtonActionEvent) {
		when (event.getButton()) {
			431 -> player.setAttackType(AttackType.WARHAMMER_BLOCK)
			432 -> player.setAttackType(AttackType.WARHAMMER_PUMMEL)
			433 -> player.setAttackType(AttackType.WARHAMMER_POUND)
		}
	}


	override fun test(event: ButtonActionEvent): Boolean {
		return event.getButton() === 431 || event.getButton() === 432 || event.getButton() === 433
	}
	
}