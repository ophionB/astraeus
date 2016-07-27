package astraeus.game.model.entity.mob.combat.dmg;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.attack.Attack;
import astraeus.game.model.entity.mob.combat.type.CombatClass;
import astraeus.game.task.TaskType;
import astraeus.game.task.impl.MobTask;

public class HitTask extends MobTask<Mob> {

	private final boolean doubleHit;
	private final CombatClass combatClass;
	private final Mob attacker;
	private final Mob defender;
	private final Hit hit;
	private final Hit secondHit;
	private final Attack attack;
	private final int delay;
	
	private int ticks = 0;
	
	public HitTask(Mob attacker, Mob defender, Hit hit, Hit secondHit, Attack attack, int delay) {
		super(attacker, 1, true, StackType.STACK, BreakType.NEVER, TaskType.COMBAT);
		this.doubleHit = attack.isDoubleHit();
		this.combatClass = attacker.getCombat().getCombatClass();
		this.attacker = attacker;
		this.defender = defender;
		this.hit = hit;
		this.secondHit = secondHit;
		this.attack = attack;
		this.delay = delay;
		attacker.startAnimation(attack.getAnimation());
		attacker.getCombat().setInCombat(true);
		defender.getCombat().setInCombat(true);
	}
	
	@Override
	public void execute() {
		if (delay > 0) {
			if (ticks++ < delay) {
				if (ticks == delay) {
					attacker.startGraphic(attack.getStartGraphic());
					defender.startGraphic(attack.getStartDefenderGraphic());
					//World.sendProjectile(attack.getProjectile(), attacker, defender);
				}
				return;
			}
		} else {
			if (ticks++ == 0) {
				//World.sendProjectile(attack.getProjectile(), attacker, defender);
				attacker.startGraphic(attack.getStartGraphic());
			}
		}
		
		if (ticks-1-delay == (doubleHit && !attack.isFastDoubleHit() ? 2 : 1)) {
			stop();
			return;
		}

		if (doubleHit) {
			if (doubleHit && ticks-1-delay == 2 || attack.isFastDoubleHit()) {
				if (attack.isFastDoubleHit()) {
					combatClass.hit(attacker, defender, secondHit, attack);
				}
				
				//World.sendProjectile(attack.getSecondProjectile(), attacker, defender);
			}
			
			attacker.startGraphic(attack.getSecondStartGraphic());
		}
		
		combatClass.hit(attacker, defender, hit, attack);
	}

	@Override
	public void onStop() {
	}
}
