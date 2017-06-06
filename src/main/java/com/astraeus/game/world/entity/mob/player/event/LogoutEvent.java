package com.astraeus.game.world.entity.mob.player.event;

import com.astraeus.game.event.Event;
import com.astraeus.game.world.entity.mob.player.Player;

public final class LogoutEvent implements Event {

  private final Player player;

  public LogoutEvent(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }


}
