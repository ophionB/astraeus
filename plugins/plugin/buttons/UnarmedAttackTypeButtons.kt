package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.combat.def.AttackType
import astraeus.game.model.entity.mob.player.Player

@SubscribesTo(ButtonActionEvent::class)
class UnarmedAttackTypeButtons : ButtonClick() {

	override fun execute(player: Player, event: ButtonActionEvent) {
		when (event.getButton()) {
			5860 -> player.setAttackType(AttackType.UNARMED_PUNCH)
			5861 -> player.setAttackType(AttackType.UNARMED_BLOCK)
			5862 -> player.setAttackType(AttackType.UNARMED_KICK)
		}
	}


	override fun test(event: ButtonActionEvent): Boolean {
		if (event.getButton() === 5860 || event.getButton() === 5861 || event.getButton() === 5862) {
			return true
		}
		return false
	}
	
	
}