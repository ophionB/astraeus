package plugin.commands.impl;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.CommandEvent;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.PlayerRights;
import astraeus.net.packet.out.ServerMessagePacket;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public final class TestCommand extends Command {

	@Override
	protected boolean execute(Player player, CommandParser parser) {
		player.queuePacket(new ServerMessagePacket("Works!"));
		return true;
	}

	@Override
	public boolean test(CommandEvent event) {
		return event.getName().equalsIgnoreCase("test");
	}

	@Override
	protected PlayerRights rights() {
		return PlayerRights.DEVELOPER;
	}

}
