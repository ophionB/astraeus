package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.mob.npc.Npc;

public final class NpcFirstClickEvent implements Event {

  private final Npc npc;

  public NpcFirstClickEvent(Npc npc) {
    this.npc = npc;
  }

  public Npc getNpc() {
    return npc;
  }

}
