package astraeus.game.event.impl;

import astraeus.game.event.Event;
import astraeus.game.model.entity.mob.npc.Npc;

public final class NpcThirdClickEvent implements Event {

  private final Npc npc;

  public NpcThirdClickEvent(Npc npc) {
    this.npc = npc;
  }

  public Npc getNpc() {
    return npc;
  }

}
