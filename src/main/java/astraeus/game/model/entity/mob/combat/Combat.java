package astraeus.game.model.entity.mob.combat;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.attack.AttackType;
import astraeus.game.model.entity.mob.combat.dmg.Hit;
import astraeus.game.model.entity.mob.combat.formula.impl.MeleeFormula;
import astraeus.util.RandomUtils;

public final class Combat {
	
	private AttackType attackType;
	
	private final MeleeFormula meleeFormula = new MeleeFormula(this);
	
	private final Mob mob;
	
	public Combat(Mob mob) {
		this.mob = mob;
	}
	
	public void attack(Mob mob) {
		mob.dealDamage(new Hit(RandomUtils.random(0, meleeFormula.calculateMaxHit())));
	}

	public AttackType getAttackType() {
		return attackType;
	}
	
	public MeleeFormula getMeleeFormula() {
		return meleeFormula;
	}

	public Mob getMob() {
		return mob;
	}

}
