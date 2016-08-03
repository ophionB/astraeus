package astraeus.game.model.entity.mob.combat;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.attack.AttackBuilder;
import astraeus.game.model.entity.mob.combat.attack.AttackType;
import astraeus.game.model.entity.mob.combat.formula.impl.MeleeFormula;
import astraeus.game.model.entity.mob.combat.task.HitTask;
import astraeus.util.Stopwatch;

public final class Combat {

  public static final int ATTACK_STAB = 0;
  public static final int ATTACK_SLASH = 1;
  public static final int ATTACK_CRUSH = 2;
  public static final int ATTACK_MAGIC = 3;
  public static final int ATTACK_RANGED = 4;
  public static final int DEFENCE_STAB = 5;
  public static final int DEFENCE_SLASH = 6;
  public static final int DEFENCE_CRUSH = 7;
  public static final int DEFENCE_MAGIC = 8;
  public static final int DEFENCE_RANGED = 9;
  public static final int BONUS_STRENGTH = 10;
  public static final int BONUS_PRAYER = 11;

  public static final String[] BONUS_NAMES = {"Stab", "Slash", "Crush", "Magic", "Range", "Stab",
      "Slash", "Crush", "Magic", "Range", "Strength", "Prayer"};

  private AttackType attackType;

  private final MeleeFormula meleeFormula = new MeleeFormula(this);

  private final AttackBuilder attackBuilder = new AttackBuilder(this);

  private final CombatTimer combatTimer = new CombatTimer();

  private final Mob mob;

  private boolean inCombat;

  private final Stopwatch combatDelay = new Stopwatch();

  public Combat(Mob mob) {
    this.mob = mob;
  }

  public void attack(Mob mob) {

    inCombat = true;

    mob.startAction(new HitTask(this, mob));

    // TODO mob animation
  }

  public void setCooldown(int delay) {
    if (inCombat && attackBuilder.getCombatType() != null) {
      getCombatTimer().setCooldown(attackBuilder.getCombatType(), delay);
    }
  }

  public AttackType getAttackType() {
    return attackType;
  }

  public MeleeFormula getMeleeFormula() {
    return meleeFormula;
  }

  public AttackBuilder getAttackBuilder() {
    return attackBuilder;
  }

  public Mob getMob() {
    return mob;
  }

  public boolean isInCombat() {
    return inCombat;
  }

  public void setInCombat(boolean inCombat) {
    this.inCombat = inCombat;
  }

  public Stopwatch getCombatDelay() {
    return combatDelay;
  }

  public CombatTimer getCombatTimer() {
    return combatTimer;
  }

}
