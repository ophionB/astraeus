package astraeus.game.model.entity.mob.combat.task;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.Combat;
import astraeus.game.model.entity.mob.combat.CombatType;
import astraeus.game.model.entity.mob.combat.dmg.Hit;
import astraeus.game.task.Task;
import astraeus.util.RandomUtils;

public final class HitTask extends Task {

  private final Combat combat;

  private final Mob defender;
  
  private int tickTimer = 0;  

  public HitTask(Combat combat, Mob defender) {
    super(0, true);
    this.combat = combat;
    this.defender = defender;
  }

  @Override
  public void execute() {
    if (!combat.isInCombat() || defender.isDead() || combat.getMob().isDead()) {
      stop();
      return;
    }
    
    // TODO range of weapons
    if (!defender.getPosition().isWithinDistance(combat.getMob().getPosition(), 1)) {
      stop();
      return;
    }

    if (!combat.getCombatCooldown().contains(CombatType.MELEE)) {
          combat.getCombatCooldown().add(CombatType.MELEE, combat.getAttackBuilder().getAttackSpeed(),
          combat.getMob());

      combat.getAttackBuilder().buildAttack();

      combat.getMob().setInteractingEntity(defender);

      defender.dealDamage(combat.getMob(), new Hit(RandomUtils.random(0, combat.getMeleeFormula().calculateMaxHit())));
      
      if (tickTimer >= 1) {
        defender.getCombat().attack(combat.getMob());
      }

      defender.setInteractingEntity(combat.getMob());
    }
    
    tickTimer++;
    
    if (tickTimer > 10_000) {
      tickTimer = 0;
    }
    
  }

}
