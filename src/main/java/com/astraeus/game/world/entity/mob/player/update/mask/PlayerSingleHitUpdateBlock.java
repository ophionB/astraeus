package com.astraeus.game.world.entity.mob.player.update.mask;

import com.astraeus.game.world.entity.mob.combat.dmg.Hit;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.skill.Skill;
import com.astraeus.game.world.entity.mob.player.update.PlayerUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock implementation that displays a single hit-mark on a player.
 * 
 * @author SeVen
 */
public class PlayerSingleHitUpdateBlock extends PlayerUpdateBlock {

  private final Hit hit;

  /**
   * Creates a new {@link PlayerSingleHitUpdateBlock}.
   */
  public PlayerSingleHitUpdateBlock(Hit hit) {
    super(0x20, UpdateFlag.HIT);
    this.hit = hit;
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    builder.write(hit.getDamage()).write(hit.getType().getId(), ByteModification.ADDITION)
        // .write(hit.getDamageType().getId()) // custom
        .write(entity.getSkills().getLevel(Skill.HITPOINTS), ByteModification.NEGATION)
        .write(entity.getSkills().getMaxLevel(Skill.HITPOINTS));
  }

}
