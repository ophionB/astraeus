package io.battlerune.game.model.entity.mob.player.update.mask;

import io.battlerune.game.model.entity.mob.combat.dmg.Hit;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.skill.Skill;
import io.battlerune.game.model.entity.mob.player.update.PlayerUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players second hit mark.
 * 
 * @author SeVen
 */
public class PlayerDoubleHitUpdateBlock extends PlayerUpdateBlock {

  private final Hit hit;

  /**
   * Creates a new {@link PlayerDoubleHitUpdateBlock}.
   */
  public PlayerDoubleHitUpdateBlock(Hit hit) {
    super(0x200, UpdateFlag.HIT);
    this.hit = hit;
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    builder.write(hit.getDamage()).write(hit.getType().getId(), ByteModification.SUBTRACTION)
        // .write(hit.getDamageType().getId()) // custom
        .write(entity.getSkills().getLevel(Skill.HITPOINTS))
        .write(entity.getSkills().getMaxLevel(Skill.HITPOINTS), ByteModification.NEGATION);
  }

}
