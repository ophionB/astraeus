package astraeus.game.model.entity.mob.combat;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.attack.AttackBuilder;
import astraeus.game.model.entity.mob.combat.attack.AttackType;
import astraeus.game.model.entity.mob.combat.formula.impl.MeleeFormula;
import astraeus.game.model.entity.mob.combat.task.HitTask;
import astraeus.util.Stopwatch;

public final class Combat {

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
