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

	public HitTask(Combat combat, Mob defender) {
		super("hitTask", combat.getMob(), 0, true, DuplicatePolicy.DISALLOW);
		this.combat = combat;
		this.defender = defender;
	}

	@Override
	public void execute() {
		if (!combat.isInCombat() || defender.isDead()) {
			stop();
			return;
		}
		
		if (!combat.getCombatTimer().cooldownTick(CombatType.MELEE)) {
			combat.getCombatTimer().setCooldown(CombatType.MELEE, combat.getAttackBuilder().getAttackSpeed());

			combat.getAttackBuilder().buildAttack();

			combat.getMob().setInteractingEntity(defender);	
			
			defender.dealDamage(new Hit(RandomUtils.random(0, combat.getMeleeFormula().calculateMaxHit())));
			
			defender.setInteractingEntity(combat.getMob());
			
			combat.getCombatDelay().reset();
		}
	}

}
