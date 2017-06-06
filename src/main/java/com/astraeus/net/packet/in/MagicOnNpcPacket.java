package com.astraeus.net.packet.in;

import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.npc.NpcDefinition;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.out.ServerMessagePacket;

@IncomingPacket.IncomingPacketOpcode({IncomingPacket.MAGIC_ON_NPC})
public final class MagicOnNpcPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    final int slot = packet.getReader().readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    final Npc mobMagic = World.getNpcs().get(slot);
    @SuppressWarnings("unused")
    final int spell = packet.getReader().readShort(ByteModification.ADDITION);

    if (mobMagic == null) {
      player.queuePacket(new ServerMessagePacket("You tried to attack a mob that doesn't exist."));
      return;
    }

    NpcDefinition def = NpcDefinition.get(mobMagic.getId());

    if (def == null) {
      return;
    }
  }

}
