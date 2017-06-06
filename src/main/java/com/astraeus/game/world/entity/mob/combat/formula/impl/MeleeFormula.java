package com.astraeus.game.world.entity.mob.combat.formula.impl;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.Mob;
import com.astraeus.game.world.entity.mob.combat.Combat;
import com.astraeus.game.world.entity.mob.combat.def.NpcCombatDefinition;
import com.astraeus.game.world.entity.mob.combat.formula.Formula;

public final class MeleeFormula extends Formula {

  public MeleeFormula(Combat combat) {
    super(combat);
  }

  @Override
  public int calculateMaxHit() {
    if (combat.getMob().isNpc()) {
      Optional<NpcCombatDefinition> def = NpcCombatDefinition.lookup(combat.getMob().getId());
      
      if (def.isPresent()) {
        return def.get().getMaxHit();
      }
      
    }
    return 30;
  }

  @Override
  public boolean isAccurate(Mob attacker, Mob defender) {
    return false;
  }


}

