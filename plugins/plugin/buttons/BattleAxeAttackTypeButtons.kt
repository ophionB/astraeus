package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.combat.def.AttackType
import astraeus.game.model.entity.mob.player.Player

@SubscribesTo(ButtonActionEvent::class)
class BattleAxeAttackTypeButtons : ButtonClick() {

	override fun execute(player: Player, event: ButtonActionEvent) {
		when (event.getButton()) {
			1704 -> player.setAttackType(AttackType.BATTLEAXE_CHOP)
			1705 -> player.setAttackType(AttackType.BATTLEAXE_BLOCK)
			1706 -> player.setAttackType(AttackType.BATTLEAXE_SMASH)
			1707 -> player.setAttackType(AttackType.BATTLEAXE_HACK)
		}
	}


	override fun test(event: ButtonActionEvent): Boolean {
		if (event.getButton() === 5860 || event.getButton() === 5861 || event.getButton() === 5862) {
			return true
		}
		return false
	}
	
}