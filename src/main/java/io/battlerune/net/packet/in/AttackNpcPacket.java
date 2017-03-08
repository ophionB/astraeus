package io.battlerune.net.packet.in;

import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.NpcDefinition;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.out.ServerMessagePacket;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ATTACK_NPC)
public final class AttackNpcPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final int npcIndex = packet.getReader().readShort(false, ByteModification.ADDITION);

    if (npcIndex < 0 || npcIndex > NpcDefinition.MOB_LIMIT) {
      return;
    }

    final Npc npc = World.getNpcs().get(npcIndex);

    if (npc == null) {
      return;
    }

    if (player.getRights().greaterOrEqual(PlayerRights.DEVELOPER)
        && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket(
          String.format("[attack= npc], [id= %d], [slot= %d]", npc.getId(), npc.getSlot())));
    }

    if (npc.getCurrentHealth() <= 0) {
      player.queuePacket(new ServerMessagePacket("This npc is already dead..."));
      return;
    }

    player.getCombat().attack(npc);

  }

}
