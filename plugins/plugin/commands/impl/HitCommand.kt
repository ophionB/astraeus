package plugin.commands.impl

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.CommandEvent
import astraeus.game.model.entity.mob.combat.dmg.DamageType
import astraeus.game.model.entity.mob.combat.dmg.Hit
import astraeus.game.model.entity.mob.combat.dmg.HitType
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.entity.mob.player.PlayerRights
import plugin.commands.Command
import plugin.commands.CommandParser

@SubscribesTo(CommandEvent::class)
class HitCommand() : Command() {

    override fun execute(player: Player, parser: CommandParser): Boolean {
        if (parser.hasNext(2)) {

            var damage = parser.nextInt();

            var type = parser.nextInt();

            if (type > 2) {
                return false
            }

            if (damage <= 0) {
                damage = 0
            } else if (damage >= 99) {
                damage = 99;
            }
            player.dealDamage(Hit(damage, HitType.values()[type], DamageType.NONE))
            return true
        } else if (parser.hasNext(1)) {

            var damage = parser.nextInt()

            if (damage <= 0) {
                damage = 0
            } else if (damage >= 99) {
                damage = 99;
            }

            player.dealDamage(Hit(damage, HitType.NORMAL, DamageType.NONE))
            return true
        }
        return false
    }

    override fun test(event: CommandEvent): Boolean {
        when (event.name) {
            "hit", "dmg" -> return true

            else -> return false
        }
    }

    override val rights: PlayerRights
        get() {
            return PlayerRights.DEVELOPER
        }

}


