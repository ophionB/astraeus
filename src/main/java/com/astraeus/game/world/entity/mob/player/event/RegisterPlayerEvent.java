package com.astraeus.game.world.entity.mob.player.event;

import com.astraeus.game.event.Event;
import com.astraeus.game.world.entity.mob.player.Player;

public final class RegisterPlayerEvent implements Event {

  private final Player player;

  public RegisterPlayerEvent(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

}
