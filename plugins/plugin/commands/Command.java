package plugin.commands;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.impl.CommandEvent;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.PlayerRights;

public abstract class Command implements EventSubscriber<CommandEvent> {
	
	@Override
	public void subscribe(EventContext ctx, Player player, CommandEvent event) {
		execute(player, CommandParser.create(event.getInput()));
	}
	
	protected abstract boolean execute(Player player, CommandParser parser);
	
	@Override
	public abstract boolean test(CommandEvent event);
	
	protected abstract PlayerRights rights();

}
