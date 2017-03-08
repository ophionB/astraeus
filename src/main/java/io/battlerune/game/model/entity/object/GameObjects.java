package io.battlerune.game.model.entity.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.out.AddObjectPacket;
import lombok.Getter;

/**
 * The class that provides static utility methods for {@link GameObject}s.
 *
 * @author Seven
 */
public final class GameObjects {

  /**
   * The list of global object spawned in the game world.
   */
  @Getter private static final List<GameObject> globalObjects = new ArrayList<>();

  /**
   * A map of ground items and their positions in the world.
   */
  @Getter private static final Map<Position, Item[]> groundItems = new HashMap<>();

  /**
   * The method that creates global objects for a user.
   * 
   * @param player The player to create the global objects for.
   */
  public static final void createGlobalObjects(Player player) {
    globalObjects.stream().filter(Objects::nonNull)
        .filter($it -> $it.getPosition().isWithinDistance(player.getPosition(), 32))
        .forEach($it -> player.queuePacket(new AddObjectPacket($it, true)));
  }

}
