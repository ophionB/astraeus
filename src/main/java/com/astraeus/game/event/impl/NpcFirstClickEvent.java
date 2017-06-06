package com.astraeus.game.event.impl;

import com.astraeus.game.event.Event;
import com.astraeus.game.world.entity.mob.npc.Npc;

public final class NpcFirstClickEvent implements Event {

  private final Npc npc;

  public NpcFirstClickEvent(Npc npc) {
    this.npc = npc;
  }

  public Npc getNpc() {
    return npc;
  }

}
