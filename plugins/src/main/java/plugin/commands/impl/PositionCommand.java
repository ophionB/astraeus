package plugin.commands.impl;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.CommandEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.packet.out.ServerMessagePacket;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class PositionCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		player.queuePacket(new ServerMessagePacket("Your position is: " + player.getPosition().toString()));
		return true;
	}

	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("pos") || event.getName().equalsIgnoreCase("mypos");
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}

}
