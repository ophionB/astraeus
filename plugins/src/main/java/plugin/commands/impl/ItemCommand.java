package plugin.commands.impl;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.CommandEvent;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;

import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class ItemCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		if (parser.hasNext(2)) {
			int id = parser.nextInt();
			
			int amount = parser.nextInt();
			
			player.getInventory().add(new Item(id, amount));
			return true;
		} else if (parser.hasNext(1)) {
			int id = parser.nextInt();
			
			player.getInventory().add(new Item(id, 1));
			return true;
		}
		return false;
	}

	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("item") || event.getName().equalsIgnoreCase("pickup");
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}

}
