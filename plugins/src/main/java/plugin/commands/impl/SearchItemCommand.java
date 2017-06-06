package plugin.commands.impl;

import java.util.Arrays;
import java.util.Objects;

import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.event.impl.CommandEvent;
import com.astraeus.game.world.entity.item.ItemDefinition;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.packet.out.ServerMessagePacket;

import plugin.commands.Command;
import plugin.commands.CommandParser;

@SubscribesTo(CommandEvent.class)
public class SearchItemCommand extends Command {

  @Override
  protected boolean execute(Player player, CommandParser parser) {
    if (parser.hasNext(1)) {
      
      final String keyword = parser.nextLine().toLowerCase();
      
      Arrays.stream(ItemDefinition.definitions).filter(it -> it.getName().toLowerCase().contains(keyword)).filter(Objects::nonNull).forEach(it -> player.queuePacket(new ServerMessagePacket(it.getId() + ":" + it.getName())));
      
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
