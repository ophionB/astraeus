package plugin.commands.impl

import astraeus.game.event.impl.CommandEvent
import astraeus.game.event.SubscribesTo
import astraeus.game.model.Animation
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.entity.mob.player.PlayerRights

import plugin.commands.Command
import plugin.commands.CommandParser

@SubscribesTo(CommandEvent::class)
class AnimationCommand : Command() {

	override fun execute(player: Player, parser: CommandParser): Boolean {
		if (parser.hasNext(1)) {
			val id = parser.nextInt()
			player.startAnimation(Animation(id))
			return true
		}
		return false
	}


	override fun test(event: CommandEvent): Boolean {
		when(event.name) {
			"anim" -> return true
		}
		return false
	}

	override val rights: PlayerRights
		get() {
			return PlayerRights.DEVELOPER
		}
}