package plugin.commands.impl;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.CommandEvent;
import io.battlerune.game.model.Animation;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class AnimationCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		if (parser.hasNext(1)) {
			
			int id = parser.nextInt();
			
			player.startAnimation(new Animation(id));
			
			return true;			
		}
		return false;
	}
	
	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("anim");		
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}


}
