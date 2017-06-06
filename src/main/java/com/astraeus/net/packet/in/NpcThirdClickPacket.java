package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.NpcThirdClickEvent;
import com.astraeus.game.task.impl.DistancedTask;
import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode({IncomingPacket.NPC_OPTION_3})
public final class NpcThirdClickPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final Npc npc = World.getNpcs().get(packet.getReader().readShort());

    if (npc == null) {
      return;
    }

    player.startAction(new DistancedTask(player, npc.getPosition(), 2) {

      @Override
      public void onReached() {
        player.setInteractingEntity(npc);
        npc.setInteractingEntity(player);
        player.post(new NpcThirdClickEvent(npc));
        stop();

      }

    });

  }

}
