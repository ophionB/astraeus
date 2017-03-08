package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.player.Player;

public final class ItemOnPlayerEvent implements Event {

  private final Item used;

  private final Player usedWith;

  public ItemOnPlayerEvent(Item used, Player usedWith) {
    this.used = used;
    this.usedWith = usedWith;
  }

  public Item getUsed() {
    return used;
  }

  public Player getUsedWith() {
    return usedWith;
  }

}
