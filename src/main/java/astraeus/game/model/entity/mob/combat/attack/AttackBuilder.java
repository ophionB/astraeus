package astraeus.game.model.entity.mob.combat.attack;

import astraeus.game.model.Animation;
import astraeus.game.model.Priority;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.combat.Combat;
import astraeus.game.model.entity.mob.combat.CombatType;
import astraeus.game.model.entity.mob.combat.def.WeaponDefinition;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.collect.Equipment;

public final class AttackBuilder {

	private final Combat combat;
	
	private CombatType combatType = CombatType.MELEE;

	public AttackBuilder(Combat combat) {
		this.combat = combat;
	}

	public void buildAttack() {
		
		combat.getMob().startAnimation(new Animation(Priority.HIGH, getAttackAnimation()));
	}
	
	public int getAttackAnimation() {
		
		if (combat.getMob().isNpc()) {
			
			return -1;
		}
	
		return combat.getMob().getPlayer().getAttackType().getAttackAnimation();
	}
	
	public int getAttackSpeed() {
		if (combat.getMob().isNpc()) {
			
			return 5;
		}
		
		Player player = combat.getMob().getPlayer();
		
		Item item = player.getEquipment().get(Equipment.WEAPON_SLOT);
		
		if (item == null) {
			return 5;
		}
		
		WeaponDefinition def = WeaponDefinition.definitions.get(item.getId());
		
		if (def == null) {
			return 5;
		}

		return def.getSpeed();	
	}

	public Combat getCombat() {
		return combat;
	}
	
	public CombatType getCombatType() {
		return combatType;
	}

	public void setCombatType(CombatType combatType) {
		this.combatType = combatType;
	}	

}
