package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.combat.def.AttackType
import astraeus.game.model.entity.mob.player.Player

@SubscribesTo(ButtonActionEvent::class)
class WhipAttackTypeWidgetButtons : ButtonClick() {

	override fun execute(player: Player, event: ButtonActionEvent) {
		when (event.getButton()) {
			12296 -> player.setAttackType(AttackType.WHIP_DEFLECT)
			12297 -> player.setAttackType(AttackType.WHIP_LASH)
			12298 -> player.setAttackType(AttackType.WHIP_FLICK)
		}
	}


	override fun test(event: ButtonActionEvent): Boolean {
		if (event.getButton() === 12296 || event.getButton() === 12297 || event.getButton() === 12298) {
			return true
		}
		return false
	}
}