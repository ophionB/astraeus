package astraeus.io;

import com.google.gson.JsonObject;

import astraeus.game.model.entity.mob.combat.CombatType;
import astraeus.game.model.entity.mob.combat.def.WeaponDefinition;
import astraeus.game.model.entity.mob.combat.def.WeaponDefinition.RangedWeaponDefinition;
import astraeus.game.model.entity.mob.combat.def.WeaponDefinition.WeaponType;
import astraeus.util.GsonParser;

public class WeaponDefinitionParser extends GsonParser {

	public WeaponDefinitionParser() {
		super("data/item/weapon_definitions");
	}

	@Override
	protected void parse(JsonObject data) {
		final int id = data.get("id").getAsInt();
		final String name = data.get("name").getAsString();
		final boolean twoHanded = data.get("twoHanded").getAsBoolean();

		CombatType combatType = CombatType.MELEE;

		if (data.has("combatType")) {
			combatType = CombatType.valueOf(data.get("combatType").getAsString());
		}

		RangedWeaponDefinition rwd = null;

		if (data.has("rangeDefinition")) {
			rwd = builder.fromJson(data.get("rangeDefinition"), RangedWeaponDefinition.class);
		}

		WeaponType weaponType = WeaponType.DEFAULT;

		if (data.has("weaponType")) {
			weaponType = WeaponType.valueOf(data.get("weaponType").getAsString());
		}

		final int blockAnimation = data.get("blockAnimation").getAsInt();
		final int standAnimation = data.get("standAnimation").getAsInt();
		final int walkAnimation = data.get("walkAnimation").getAsInt();
		final int runAnimation = data.get("runAnimation").getAsInt();
		final int attackSpeed = data.get("attackSpeed").getAsInt();

		final int[] animations = data.has("animations") ? builder.fromJson(data.get("animations"), int[].class) : new int[] { 65535, 65535, 65535, 65535 };

		WeaponDefinition.getWeaponDefinitions().put(id, new WeaponDefinition(id, name, weaponType, combatType, rwd, twoHanded, blockAnimation, standAnimation, walkAnimation, runAnimation, attackSpeed, animations));
	}
	
}