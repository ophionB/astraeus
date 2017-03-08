package astraeus.game.model.entity.mob.npc;

import java.util.Objects;
import java.util.Optional;

import astraeus.game.GameConstants;
import astraeus.game.model.Direction;
import astraeus.game.model.Position;
import astraeus.game.model.World;
import astraeus.game.model.entity.EntityType;
import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition;
import astraeus.game.model.entity.mob.combat.dmg.Hit;
import astraeus.game.model.entity.mob.combat.task.MobDeathTask;
import astraeus.game.model.entity.mob.update.UpdateFlag;
import astraeus.game.model.location.Area;
import astraeus.util.Stopwatch;
import lombok.Getter;
import lombok.Setter;

public class Npc extends Mob {

  @Getter
  private Direction facingDirection = Direction.SOUTH;

  @Getter
  @Setter
  private int maximumHealth;

  @Getter
  @Setter
  private int currentHealth;

  @Getter
  @Setter
  private boolean randomWalk;

  @Getter
  @Setter
  private int respawnTimer;

  @Getter
  private final Stopwatch randomWalkTimer = new Stopwatch();

  @Getter
  @Setter
  private boolean following;

  public Npc(int id) {
    super(GameConstants.DEFAULT_LOCATION);
    setId(id);
    size = NpcDefinition.get(id).getSize();
    
    Optional<NpcCombatDefinition> npcCombatDef = NpcCombatDefinition.lookup(id);
    
    currentHealth = npcCombatDef.isPresent() ? npcCombatDef.get().getHitpoints() : 100;
    maximumHealth = npcCombatDef.isPresent() ? npcCombatDef.get().getHitpoints() : 100;
  }

  @Override
  public void onDeath() {

  }

  @Override
  public void onMovement() {

  }

  @Override
  public int size() {
    return NpcDefinition.get(getId()).getSize();
  }

  public String getName() {
    return NpcDefinition.getDefinitions()[getId()].getName();
  }

  public String getName(int npcId) {
    if (NpcDefinition.getDefinitions()[npcId] == null || npcId < 0
        || npcId >= NpcDefinition.MOB_LIMIT) {
      return "None";
    }
    return NpcDefinition.getDefinitions()[npcId].getName();
  }

  @Override
  public void preUpdate() {

    movement.handleEntityMovement();

    tick();

    if (!isRandomWalk() && getInteractingEntity() == null && getTick() % 5 == 4) {
      Npcs.resetFacingDirection(this);
    }

    if (!isDead() && getInteractingEntity() == null) {
      resetEntityInteraction();
    }

    if (isRandomWalk() && getInteractingEntity() == null && getTick() % 5 == 4) {
      Npcs.handleRandomWalk(this);
    }
  }

  @Override
  public void postUpdate() {
    getUpdateFlags().clear();
    getAnimations().clear();
    getGraphics().clear();
  }

  public void setFacingDirection(Direction facingDirection) {
    this.facingDirection = facingDirection;
    getUpdateFlags().add(UpdateFlag.FACE_COORDINATE);
  }

  /**
   * The mob should walk to home
   * 
   * @return If the mob can walk to home or not
   */
  public boolean isWalkToHome() {
    if (Area.inWilderness(this)) {
      return Math.abs(getPosition().getX() - createdPosition.getX())
          + Math.abs(getPosition().getY() - createdPosition.getY()) > getSize() * 1 + 2;
    }

    if (isNpc()) { // TODO: isAttackable
      return Math.abs(getPosition().getX() - createdPosition.getX())
          + Math.abs(getPosition().getY() - createdPosition.getY()) > getSize() * 2 + 6;
    }

    return Position.getManhattanDistance(createdPosition, getPosition()) > 2;
  }

  @Override
  public void onTick() {

  }

  @Override
  public void dealDamage(Mob attacker, Hit hit) {
    
    if (isDead()) {
      return;
    }
    
    if (getCurrentHealth() - hit.getDamage() <= 0) {
      hit.setDamage(getCurrentHealth());
      setDead(true);
      World.submit(new MobDeathTask(attacker, this));
    }

    setCurrentHealth(getCurrentHealth() - hit.getDamage());

    hitQueue.add(hit);
    getUpdateFlags().add(UpdateFlag.HIT);
  }

  @Override
  public EntityType type() {
    return EntityType.NPC;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getSlot());
  }

  public String toString() {
    return String.format("[MOB] - [name= %s] [id= %d] [slot= %d] [location= %s]", getName(),
        getId(), getSlot(), getPosition().toString());
  }

}
