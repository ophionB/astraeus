package plugin.commands;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.impl.CommandEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;

public abstract class Command implements EventSubscriber<CommandEvent> {
	
	@Override
	public void subscribe(EventContext ctx, Player player, CommandEvent event) {
	  
	  if (player == null) {
	    return;
	  }
	  
	  if (player.getRights().greaterOrEqual(rights())) {
	       execute(player, CommandParser.create(event.getInput()));
	  }	  

	}
	
	protected abstract boolean execute(Player player, CommandParser parser);
	
	@Override
	public abstract boolean test(CommandEvent event);
	
	protected abstract PlayerRights rights();

}
