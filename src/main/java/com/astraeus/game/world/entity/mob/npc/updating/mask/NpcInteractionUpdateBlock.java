package com.astraeus.game.world.entity.mob.npc.updating.mask;

import com.astraeus.game.world.entity.mob.Mob;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.npc.updating.NpcUpdateBlock;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.game.GamePacketBuilder;

public class NpcInteractionUpdateBlock extends NpcUpdateBlock {

  public NpcInteractionUpdateBlock() {
    super(0x20, UpdateFlag.ENTITY_INTERACTION);
  }

  @Override
  public void encode(Npc mob, GamePacketBuilder builder) {
    final Mob entity = (Mob) mob.getInteractingEntity();
    builder.writeShort(entity == null ? -1
        : (entity instanceof Player) ? entity.getSlot() + 32768 : entity.getSlot());
  }

}
