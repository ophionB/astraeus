package com.astraeus.game.world.entity.mob.npc.updating.mask;

import com.astraeus.game.world.entity.mob.combat.dmg.Hit;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.npc.updating.NpcUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;

public final class NpcDoubleHitUpdateBlock extends NpcUpdateBlock {
  private final Hit hit;

  public NpcDoubleHitUpdateBlock(Hit hit) {
    super(0x8, UpdateFlag.HIT);
    this.hit = hit;
  }

  @Override
  public void encode(Npc npc, GamePacketBuilder builder) {
    builder.write(hit.getDamage(), ByteModification.ADDITION)
        .write(hit.getType().getId(), ByteModification.NEGATION)
        // .write(hit.getDamageType().getId()) // custom
        .write(npc.getCurrentHealth(), ByteModification.ADDITION).write(npc.getMaximumHealth());
  }

}
