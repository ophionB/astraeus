package plugin.commands.impl;

import java.util.Arrays;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.CommandEvent;
import astraeus.game.model.entity.item.ItemDefinition;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.PlayerRights;
import astraeus.net.packet.out.ServerMessagePacket;
import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public class SearchItemCommand extends Command {

  @Override
  protected boolean execute(Player player, CommandParser parser) {
    if (parser.hasNext(1)) {
      
      final String keyword = parser.nextLine().toLowerCase();
      
      Arrays.stream(ItemDefinition.definitions).filter(it -> it.getName().toLowerCase().contains(keyword)).forEach(it -> player.queuePacket(new ServerMessagePacket(it.getId() + ":" + it.getName())));
      
      return true;
    }
    return false;
  }

  @Override
  public boolean test(CommandEvent event) {
    return event.getName().equalsIgnoreCase("sitem");
  }

  @Override
  protected PlayerRights rights() {
    return PlayerRights.DEVELOPER;
  }

}
