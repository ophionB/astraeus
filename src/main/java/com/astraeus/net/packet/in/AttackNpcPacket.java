package com.astraeus.net.packet.in;

import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.npc.NpcDefinition;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.out.ServerMessagePacket;

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
