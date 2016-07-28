package plugin.commands.impl

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.CommandEvent
import astraeus.game.model.entity.mob.combat.dmg.DamageType
import astraeus.game.model.entity.mob.combat.dmg.Hit
import astraeus.game.model.entity.mob.combat.dmg.HitType
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.entity.mob.player.PlayerRights
import astraeus.net.packet.out.ServerMessagePacket

import plugin.commands.Command
import plugin.commands.CommandParser

@SubscribesTo(CommandEvent::class)
class MaxHitCommand() : Command() {

    override fun execute(player: Player, parser: CommandParser): Boolean {
		player.queuePacket(ServerMessagePacket("melee max hit: ${player.combat.meleeFormula.calculateMaxHit()}"))		
        return true
    }

    override fun test(event: CommandEvent): Boolean {
        when (event.name) {
            "maxhit", "mhit" -> return true
            else -> return false
        }
    }

    override val rights: PlayerRights
        get() {
            return PlayerRights.DEVELOPER
        }

}


