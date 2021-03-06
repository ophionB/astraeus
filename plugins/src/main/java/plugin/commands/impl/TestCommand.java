package plugin.commands.impl;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.CommandEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.packet.out.ServerMessagePacket;

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
