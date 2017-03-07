package astraeus.game.model.entity.mob.combat.attack;

import java.util.Optional;

import astraeus.game.model.Animation;
import astraeus.game.model.Priority;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.combat.Combat;
import astraeus.game.model.entity.mob.combat.CombatType;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition;
import astraeus.game.model.entity.mob.combat.def.WeaponDefinition;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.collect.Equipment;
import lombok.Getter;

public final class AttackBuilder {

  @Getter private final Combat combat;

  @Getter private CombatType combatType = CombatType.MELEE;

  public AttackBuilder(Combat combat) {
    this.combat = combat;
  }

  public void buildAttack() {

    combat.getMob().startAnimation(new Animation(Priority.HIGH, getAttackAnimation()));
  }

  public int getAttackAnimation() {

    if (combat.getMob().isNpc()) {

      Optional<NpcCombatDefinition> def = NpcCombatDefinition.lookup(combat.getMob().getId());
      
      if (def.isPresent()) {
        
        switch (combatType) {
            
          case MELEE:
            return def.get().getAttackAnimations()[0];
            
          case RANGE:
            return def.get().getAttackAnimations()[1];
            
          case MAGIC:
            return def.get().getAttackAnimations()[2];
          
        }
        
      }
      
      return 806;
    }

    return combat.getMob().getPlayer().getAttackType().getAttackAnimation();
  }

  public int getAttackSpeed() {
    
    if (combat.getMob().isNpc()) {
      
      Optional<NpcCombatDefinition> def = NpcCombatDefinition.lookup(combat.getMob().getId());
      
      if (def.isPresent()) {
        return def.get().getAttackSpeed();
      }

      return 6;
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

}
