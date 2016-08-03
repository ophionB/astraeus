package astraeus.game.model.entity.mob.combat.formula.impl;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.Combat;
import astraeus.game.model.entity.mob.combat.formula.Formula;

public final class MeleeFormula extends Formula {

  public MeleeFormula(Combat combat) {
    super(combat);
  }

  @Override
  public int calculateMaxHit() {
    // TODO calculate max hit
    return 30;
  }

  @Override
  public boolean isAccurate(Mob attacker, Mob defender) {
    return false;
  }


}

