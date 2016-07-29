package astraeus.game.model.entity.mob.combat;

public class CombatTimer {

	private int meleeCooldown;
	
	public boolean hasCooldown(CombatType type) {
		int diff = 4;

		if (meleeCooldown < diff) {			
			if (type == CombatType.MELEE) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean cooldownTick(CombatType type) {
		boolean cooldown = false;
		if (meleeCooldown >= 1) {
			meleeCooldown--;
			
			if (type == CombatType.MELEE && meleeCooldown >= 1) {
				cooldown = true;
			}
		}		
		return cooldown;
	}

	public void setCooldown(CombatType type, int delay) {
		switch (type) {
		case MELEE:
			meleeCooldown = (byte) delay;
			break;
		case RANGE:
			break;
		default:
			break;
		}
	}
	
	public void setMeleeCooldown(byte meleeCooldown) {
		this.meleeCooldown = meleeCooldown;
	}

}
