package astraeus.game.model.entity.mob;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

import astraeus.GameEngine;
import astraeus.game.model.Animation;
import astraeus.game.model.Graphic;
import astraeus.game.model.Position;
import astraeus.game.model.World;
import astraeus.game.model.entity.Entity;
import astraeus.game.model.entity.EntityType;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.combat.Combat;
import astraeus.game.model.entity.mob.combat.dmg.Hit;
import astraeus.game.model.entity.mob.combat.dmg.Poison.DamageTypes;
import astraeus.game.model.entity.mob.npc.Npc;
import astraeus.game.model.entity.mob.player.ForceMovement;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.attr.AttributeMap;
import astraeus.game.model.entity.mob.player.skill.SkillSet;
import astraeus.game.model.entity.mob.update.UpdateFlag;
import astraeus.game.model.entity.object.GameObject;
import astraeus.game.task.Task;
import astraeus.util.Stopwatch;
import lombok.Getter;
import lombok.Setter;

/**
 * The class that represents a mobile entity that is either a NPC (Non-Playable-Character) or
 * Player.
 * 
 * @author Vult-R
 */
public abstract class Mob extends Entity {

  @Getter
  private final List<Player> localPlayers = new LinkedList<Player>();

  @Getter
  private final List<Npc> localNpcs = new LinkedList<Npc>();

  @Getter
  protected final EnumSet<UpdateFlag> updateFlags = EnumSet.noneOf(UpdateFlag.class);

  @Getter
  private final Queue<Animation> animations = new PriorityQueue<>();

  @Getter
  private final Queue<Graphic> graphics = new PriorityQueue<>();

  @Getter
  protected final AttributeMap attr = new AttributeMap();

  @Getter
  protected final Combat combat = new Combat(this);

  @Getter
  @Setter
  private SkillSet skills = new SkillSet(this);

  @Getter
  @Setter
  private Position lastPosition = new Position(0, 0, 0);

  @Getter
  @Setter
  private DamageTypes poisonType;

  @Getter
  @Setter
  protected int slot;

  @Getter
  private Position facingLocation;

  @Getter
  protected final Movement movement = new Movement(this);

  @Getter
  private ForceMovement forceMovement;

  @Getter
  private Mob interactingEntity;

  @Getter
  @Setter
  private Optional<Task> currentAction = Optional.empty();

  @Getter
  protected final Deque<Hit> hitQueue = new ArrayDeque<>();

  @Getter
  @Setter
  private int antipoisonTimer = 0;
  @Getter
  @Setter
  private int id;

  protected int size = 1;

  @Getter
  @Setter
  private int walkingDirection = -1;

  @Getter
  @Setter
  private int runningDirection = -1;

  @Getter
  private Stopwatch lastPoisoned = new Stopwatch();

  @Getter
  private final MobAnimation mobAnimation = new MobAnimation();

  @Getter
  @Setter
  private boolean registered;
  @Getter
  @Setter
  private boolean poisoned;
  @Getter
  @Setter
  private boolean isDead;
  @Getter
  @Setter
  private boolean regionChange;
  @Getter
  @Setter
  private boolean teleporting;
  @Getter
  @Setter
  private boolean visible;
  @Getter
  @Setter
  private boolean following;

  @Getter
  private String forcedChat;

  @Getter
  @Setter
  private int immunity;

  public Mob(Position position) {
    this.position = position;
  }

  /**
   * The method called on a game tick.
   */
  public abstract void onTick();

  public abstract int getCurrentHealth();

  @Getter
  public static int tick = GameEngine.tick;

  /**
   * The method that increments tick to time actions
   */
  protected void tick() {

    tick = GameEngine.tick;

    onTick();

    if (tick >= 1000) {
      tick = 0;
    }

  }

  /**
   * Gets the maximum number of hitpoints an entity has.
   */
  public abstract int getMaximumHealth();

  /**
   * The method called before the mob is updated.
   */
  public abstract void preUpdate();

  /**
   * The method called during an update. This should only be used for a player, since a player will
   * send the PlayerUpdatePacket, and NpcUpdatePacket right after it.
   */
  public void update() {

  }

  /**
   * The method called after a mob is updated.
   */
  public abstract void postUpdate();

  /**
   * The method called when an entity dies.
   */
  public abstract void onDeath();

  /**
   * The method called when an entity walks or runs.
   */
  public abstract void onMovement();

  public abstract void dealDamage(Hit hit);

  public void startAction(Task currentAction) {
    this.currentAction.ifPresent(it -> {
      if (it.equals(currentAction)) {
        return;
      }
      stopAction();
    });

    this.currentAction = Optional.of(currentAction);
    World.world.submit(currentAction);
  }

  public void stopAction() {
    currentAction.ifPresent(it -> {
      it.setInterrupt(true);
      it.stop();
      currentAction = Optional.empty();
    });
  }

  public AttributeMap attr() {
    return attr;
  }

  /**
   * Determines if this {@link Player} can logout.
   * 
   * @return {@code true} If this player can logout. {@code false} Otherwise.
   */
  public boolean canLogout() {
    return true;
  }

  public boolean canTeleport() {
    return true;
  }

  public boolean canClickButton() {
    return true;
  }

  public boolean canTrade() {
    return true;
  }

  public boolean canDuel() {
    return true;
  }

  public boolean canAttackMob(Npc mob) {
    return true;
  }

  public boolean canAttackPlayer(Player player) {
    return true;
  }

  public boolean canClickMob(Npc mob) {
    return true;
  }

  public boolean canClickObject(GameObject object) {
    return true;
  }

  public boolean canDrink() {
    return true;
  }

  public boolean canEat() {
    return true;
  }

  public boolean canDrop() {
    return true;
  }

  public boolean canMove() {
    return true;
  }

  public boolean canPickup(Item item) {
    return true;
  }

  public boolean canSave() {
    return true;
  }

  public boolean canPray() {
    return true;
  }

  public boolean canTalk() {
    return true;
  }

  public boolean canUnequip(Item item) {
    return true;
  }

  public boolean canUseSpecial() {
    return true;
  }

  public Npc getNpc() {
    return World.world.getMobs().get(slot);
  }

  public Player getPlayer() {
    return World.world.getPlayers().get(slot);
  }

  public int getSize() {
    return size;
  }

  public boolean isUpdateRequired() {
    return !updateFlags.isEmpty();
  }

  public boolean isNpc() {
    return type() == EntityType.NPC;
  }

  public boolean isPlayer() {
    return type() == EntityType.PLAYER;
  }

  @Override
  public boolean isMob() {
    return getClass() == Mob.class;
  }

  public void resetEntityInteraction() {
    if (this.getInteractingEntity() != null) {
      this.getInteractingEntity().setInteractingEntity(null);
      this.interactingEntity = null;
    }
    updateFlags.add(UpdateFlag.ENTITY_INTERACTION);
  }

  public void setForcedChat(String forcedChat) {
    this.forcedChat = forcedChat;
    updateFlags.add(UpdateFlag.FORCED_CHAT);
  }

  public void setInteractingEntity(Mob entity) {
    this.interactingEntity = entity;
    updateFlags.add(UpdateFlag.ENTITY_INTERACTION);
  }
  
  private final Stopwatch lastAnimation = new Stopwatch();
  
  public void startAnimation(final Animation animation) {
    startAnimation(animation, 0);
  }

  public void startAnimation(final Animation animation, int delay) {
    if (lastAnimation.elapsed() < delay) {
      return;
    }    
    
    if (animation != null) {
      animations.add(animation);
      updateFlags.add(UpdateFlag.ANIMATION);
      lastAnimation.reset();
    }
  }
  
  public void startGraphic(Graphic graphic) {
    startGraphic(graphic, 0);
  }

  public void startGraphic(Graphic graphic, int delay) {
    if (lastAnimation.elapsed() < delay) {
      return;
    }
    
    if (graphic != null) {
      graphics.add(graphic);
      updateFlags.add(UpdateFlag.GRAPHICS);
      lastAnimation.reset();
    }
  }

  public void setForceMovement(ForceMovement forceMovement) {
    this.forceMovement = forceMovement;
    updateFlags.add(UpdateFlag.FORCE_MOVEMENT);
  }

  public void faceLocation(Position facingLocation) {
    this.facingLocation = facingLocation;
    updateFlags.add(UpdateFlag.FACE_COORDINATE);
  }

  public Animation getAnimation() {
    return animations.peek() == null ? new Animation(65535) : animations.peek();
  }

  public Graphic getGraphic() {
    return graphics.peek() == null ? new Graphic(65535) : graphics.peek();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }

    if (o instanceof Mob) {
      Mob entity = (Mob) o;
      return hashCode() == entity.hashCode();
    }
    return false;
  }
}
