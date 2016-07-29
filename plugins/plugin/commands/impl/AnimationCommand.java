package plugin.commands.impl;

import astraeus.game.event.impl.CommandEvent;
import astraeus.game.event.SubscribesTo;
import astraeus.game.model.Animation;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.PlayerRights;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class AnimationCommand extends Command {

	@Override
	public boolean execute(Player player, CommandParser parser) {
		
		if (parser.hasNext(1)) {
			int id = parser.nextInt();
			
			player.startAnimation(new Animation(id));
			return true;
		}
		
		return false;
	}

	@Override
	public PlayerRights getRights() {
		return PlayerRights.DEVELOPER;
	}

}
