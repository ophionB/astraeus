package io.battlerune.game.model.entity.mob.player.event;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.mob.player.Player;

public final class PostLoginEvent implements Event {

  private final Player player;

  public PostLoginEvent(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

}
