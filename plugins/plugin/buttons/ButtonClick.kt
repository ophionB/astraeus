package plugin.buttons

import astraeus.game.event.EventContext
import astraeus.game.event.EventSubscriber
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.player.Player

public abstract class ButtonClick : EventSubscriber<ButtonActionEvent> {

	override fun subscribe(context: EventContext, player: Player, event: ButtonActionEvent) {
		execute(player, event)
	}

	abstract fun execute(player: Player, event: ButtonActionEvent)
}