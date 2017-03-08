package io.battlerune.game.model.entity.mob.npc.updating.mask;

import io.battlerune.game.model.entity.mob.combat.dmg.Hit;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.updating.NpcUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;

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
