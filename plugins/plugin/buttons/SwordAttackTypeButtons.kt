package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.combat.def.AttackType
import astraeus.game.model.entity.mob.player.Player

@SubscribesTo(ButtonActionEvent::class)
class SwordAttackTypeButtons : ButtonClick() {

	override fun execute(player: Player, event: ButtonActionEvent) {
		when (event.getButton()) {
			2282 -> player.setAttackType(AttackType.SWORD_STAB)
			2283 -> player.setAttackType(AttackType.SWORD_BLOCK)
			2284 -> player.setAttackType(AttackType.SWORD_SLASH)
			2285 -> player.setAttackType(AttackType.SWORD_LUNGE)
		}
	}


	override fun test(event: ButtonActionEvent): Boolean {
		if (event.getButton() === 2282 || event.getButton() === 2285 || event.getButton() === 2284 || event.getButton() === 2283) {
			return true
		}
		return false
	}
	
}