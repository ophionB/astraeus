package plugin.commands.impl;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.CommandEvent;
import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class TeleportCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		
		if (parser.hasNext(3)) {
			
			int x = parser.nextInt();
			
			int y = parser.nextInt();
			
			int z = parser.nextInt();
			
			player.move(new Position(x, y, z));			
		} else if (parser.hasNext(2)) {
			int x = parser.nextInt();
			
			int y = parser.nextInt();
			
			player.move(new Position(x, y));	
		}
		
		
		return true;
	}

	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("tele");
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}

}
