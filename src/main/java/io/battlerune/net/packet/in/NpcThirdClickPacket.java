package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.NpcThirdClickEvent;
import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.task.impl.DistancedTask;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

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
