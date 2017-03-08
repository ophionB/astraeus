package io.battlerune.net.packet.in;

import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.NpcDefinition;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.out.ServerMessagePacket;

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
