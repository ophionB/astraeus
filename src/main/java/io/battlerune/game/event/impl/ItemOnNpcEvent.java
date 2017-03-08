package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.mob.npc.Npc;

public final class ItemOnNpcEvent implements Event {

  private final Item item;

  private final Npc npc;

  public ItemOnNpcEvent(Item item, Npc npc) {
    this.item = item;
    this.npc = npc;
  }

  public Item getItem() {
    return item;
  }

  public Npc getNpc() {
    return npc;
  }

}
