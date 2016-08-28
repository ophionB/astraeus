package astraeus.game.model.entity.mob.combat;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.task.Task;
import lombok.Getter;

/**
 * The {@link Task} that resets combat cooldowns.
 * 
 * @author Vult-R
 */
public final class CooldownTask extends Task {
  
  @Getter private final Mob mob;
  
  @Getter private final CombatType cooldown;
  
  @Getter private final int delay;
  
  public CooldownTask(Mob mob, CombatType cooldown, int delay) {
    super(delay, false);
    this.mob = mob;
    this.cooldown = cooldown;
    this.delay = delay;
  }

  @Override
  public void execute() {
      if (tick >= delay) {
        mob.getCombat().getCombatCooldown().reset(cooldown);
        stop();
      }
  }

}
