package plugin.commands.impl;

import java.util.Arrays;
import java.util.Objects;

import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.event.impl.CommandEvent;
import io.battlerune.game.model.entity.item.ItemDefinition;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.packet.out.ServerMessagePacket;
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
