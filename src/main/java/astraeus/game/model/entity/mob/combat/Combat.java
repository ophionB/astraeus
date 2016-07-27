package astraeus.game.model.entity.mob.combat;

import astraeus.game.model.World;
import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.attack.Attack;
import astraeus.game.model.entity.mob.combat.dmg.DamageType;
import astraeus.game.model.entity.mob.combat.dmg.Hit;
import astraeus.game.model.entity.mob.combat.dmg.HitTask;
import astraeus.game.model.entity.mob.combat.dmg.HitType;
import astraeus.game.model.entity.mob.combat.type.CombatType;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.attr.AttributeKey;
import astraeus.game.task.Task;
import astraeus.util.RandomUtils;

public final class Combat extends CombatFields {
	
	public static final AttributeKey<Boolean> TELE_BLOCK_KEY = AttributeKey.valueOf("teleblock", false);
	
	public Combat(Mob mob) {
		super(mob);
	}
	
	public void execute() {
		if (getDefender() == null) {
			return;
		}
		
		setAttack();
		
		if (getDefender().isDead()) {
			return;
		}
		
		getEntity().setInteractingEntity(getDefender());
		
		if (getCombatClass().canAttack(getEntity(), getDefender())) {
			if (getCombatClass().withinDistance(getEntity(), getDefender())) {
				getCombatTimer().setCooldown(getCombatType(), getEntity().getCombatDelay());
				World.world.submit(getHitTask(getAttack().isDoubleHit()));
			}
		} else {
			reset();
		}
	}
	
	public void setAttack() {
		getEntity().setAttack();
		getEntity().setCombatAnimations();

		if (getCombatClass() != null) {
			getCombatClass().buildAttack(getEntity());
		}
	}
	
	public void attack(Mob victim) {
		attack(victim, false);
	}

	public void attack(Mob victim, boolean ignoreDistance) {

	}
	
	public boolean withinDistanceForAttack(Mob defender, CombatType type, boolean noMovement) {
		if (getCombatClass() == null) {
			return false;
		}

		if (type == null) {
			type = getCombatType();
		}

		@SuppressWarnings("unused")
		int dist = type == CombatType.MELEE ? 1 : type != CombatType.RANGE ? 10 : 8;

		if (!noMovement && !getEntity().isMob() && !defender.isMob() && getEntity().getMovement().isMoving() && defender.getMovement().isMoving()) {
			dist += 3;
		}
		return this.getAttackedBy().getPosition().isWithinInteractionDistance(defender.getPosition());
//		return defender.withinCombatDistance(type, getEntity(), dist, false);
	}
	
	private Task getHitTask(boolean doubleHit) {
		Attack attack = getAttack().copy();

		Hit hit = new Hit(0, DamageType.of(attack.getCombatType()));
		Hit secondHit = new Hit(0, DamageType.of(attack.getCombatType()));
		int damage = RandomUtils.random(attack.getMaxHit());
		int secondDamage = RandomUtils.random(attack.getMaxHit());

		if (getCombatClass().isAccurate(getEntity(), getDefender())) {
			hit = new Hit(damage, damage == attack.getMaxHit() ? HitType.CRITICAL : HitType.NORMAL, DamageType.of(attack.getCombatType()));
		} else if (getCombatType() == CombatType.MAGIC) {
			hit = null;
		}
		
		if (doubleHit) {
			if (getCombatClass().isAccurate(getEntity(), getDefender())) {
				secondHit = new Hit(secondDamage, secondDamage == attack.getMaxHit() ? HitType.CRITICAL : HitType.NORMAL, DamageType.of(attack.getCombatType()));
				secondHit.setSecond(true);
			} else if (getCombatType() == CombatType.MAGIC) {
				secondHit = null;
			}
		}

		if (getEntity().isPlayer()) {
			Player player = getEntity().getPlayer();

			int total = 0;
			
			if (hit != null) {
				total += hit.getDamage();
			}
			
			if (doubleHit && secondHit != null) {
				total += secondHit.getDamage();
			}

			player.getSkills().addCombatExperience(getCombatType(), total);
		}

		return new HitTask(getEntity(), getDefender(), hit, secondHit, attack, attack.getDelay());
	}
	
	public void reset() {
		setInCombat(false);
		setDefender(null);
		setFirstHit(true);
		setInCombat(false);
		getEntity().resetEntityInteraction();
		getEntity().setFollowing(false);
	}

}
