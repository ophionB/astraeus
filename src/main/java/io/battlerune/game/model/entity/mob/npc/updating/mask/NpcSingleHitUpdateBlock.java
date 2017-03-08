package io.battlerune.game.model.entity.mob.npc.updating.mask;

import io.battlerune.game.model.entity.mob.combat.dmg.Hit;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.updating.NpcUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;

/**
 * {@link NpcUpdateBlock} implementation that displays a single hit-splat on a mob.
 * 
 * @author SeVen
 */
public class NpcSingleHitUpdateBlock extends NpcUpdateBlock {

  private final Hit hit;

  public NpcSingleHitUpdateBlock(Hit hit) {
    super(0x40, UpdateFlag.HIT);
    this.hit = hit;
  }

  @Override
  public void encode(Npc npc, GamePacketBuilder builder) {
    builder.write(hit.getDamage(), ByteModification.NEGATION)
        .write(hit.getType().getId(), ByteModification.SUBTRACTION)
        // .write(hit.getDamageType().getId()) // custom
        .write(npc.getCurrentHealth(), ByteModification.SUBTRACTION)
        .write(npc.getMaximumHealth(), ByteModification.NEGATION);
  }

}
