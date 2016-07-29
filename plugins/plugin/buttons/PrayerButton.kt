package plugin.buttons

import astraeus.game.event.SubscribesTo
import astraeus.game.event.impl.ButtonActionEvent
import astraeus.game.model.entity.mob.player.Player
import astraeus.game.model.entity.mob.player.CombatPrayer

@SubscribesTo(ButtonActionEvent::class)
class PrayerButton : ButtonClick() {

    override fun execute(player: Player, event: ButtonActionEvent) {
        player.prayer.clickButton(event.button)
    }

    override fun test(event: ButtonActionEvent): Boolean {
        return CombatPrayer.isPrayerButton(event.button)
    }

}