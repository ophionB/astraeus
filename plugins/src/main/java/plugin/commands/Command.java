package plugin.commands;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.impl.CommandEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;

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
