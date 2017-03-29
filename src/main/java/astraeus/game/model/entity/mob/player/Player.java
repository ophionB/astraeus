package astraeus.game.model.entity.mob.player;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import astraeus.game.event.Event;
import astraeus.game.model.Brightness;
import astraeus.game.model.Position;
import astraeus.game.model.World;
import astraeus.game.model.entity.EntityType;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.Mob;
import astraeus.game.model.entity.mob.Movement;
import astraeus.game.model.entity.mob.combat.CombatPrayer;
import astraeus.game.model.entity.mob.combat.def.AttackType;
import astraeus.game.model.entity.mob.combat.def.WeaponSpecial;
import astraeus.game.model.entity.mob.combat.def.WeaponType;
import astraeus.game.model.entity.mob.combat.dmg.Hit;
import astraeus.game.model.entity.mob.npc.Npc;
import astraeus.game.model.entity.mob.player.attr.AttributeKey;
import astraeus.game.model.entity.mob.player.collect.Bank;
import astraeus.game.model.entity.mob.player.collect.Equipment;
import astraeus.game.model.entity.mob.player.collect.Inventory;
import astraeus.game.model.entity.mob.player.event.LogoutEvent;
import astraeus.game.model.entity.mob.player.io.PlayerContainer;
import astraeus.game.model.entity.mob.player.io.PlayerDetails;
import astraeus.game.model.entity.mob.player.skill.Skill;
import astraeus.game.model.entity.mob.update.UpdateFlag;
import astraeus.game.model.entity.object.GameObject;
import astraeus.game.model.location.Area;
import astraeus.game.model.sound.Volume;
import astraeus.game.model.widget.WidgetSet;
import astraeus.game.model.widget.dialog.Dialogue;
import astraeus.game.model.widget.dialog.DialogueFactory;
import astraeus.game.model.widget.dialog.OptionDialogue;
import astraeus.net.channel.PlayerChannel;
import astraeus.net.packet.Sendable;
import astraeus.net.packet.out.DisplayMultiIconPacket;
import astraeus.net.packet.out.DisplayWalkableWidgetPacket;
import astraeus.net.packet.out.LogoutPlayerPacket;
import astraeus.net.packet.out.SetPlayerOptionPacket;
import astraeus.net.packet.out.SetRunEnergyPacket;
import astraeus.net.packet.out.SetWidgetConfigPacket;
import astraeus.net.packet.out.SetWidgetStringPacket;
import astraeus.net.packet.out.UpdateNpcPacket;
import astraeus.net.packet.out.UpdatePlayerPacket;
import astraeus.util.LoggerUtils;
import astraeus.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

public class Player extends Mob {

  private final Logger logger = LoggerUtils.getLogger(Player.class);

  /**
   * The default appearance of a player.
   */
  public static final Appearance DEFAULT_APPEARANCE =
      new Appearance(Appearance.Gender.MALE, 0, 10, 18, 26, 33, 36, 42, 7, 8, 9, 5, 0);

  /**
   * The default location a player will spawn.
   */
  public static final Position DEFAULT_SPAWN = new Position(3086, 3499);

  /**
   * The default location a player will spawn if they died.
   */
  public static final Position DEFAULT_RESPAWN = new Position(3087, 3502);

  @Getter
  @Setter
  private ChatMessage chatMessage = new ChatMessage();
  @Getter
  private final PlayerRelation playerRelation = new PlayerRelation(this);
  @Getter
  private final Inventory inventory = new Inventory(this);
  @Getter
  private final Equipment equipment = new Equipment(this);
  @Getter
  private final Bank bank = new Bank(this);
  @Getter
  private final WidgetSet widgets = new WidgetSet(this);
  @Getter
  private final CombatPrayer combatPrayer = new CombatPrayer(this);
  @Getter
  private final DialogueFactory dialogueFactory = new DialogueFactory(this);
  @Getter
  @Setter
  private Optional<Dialogue> dialogue = Optional.empty();
  @Getter
  @Setter
  private Optional<OptionDialogue> optionDialogue = Optional.empty();

  @Getter
  @Setter
  private WeaponType weaponType = WeaponType.UNARMED;

  @Getter
  @Setter
  private AttackType attackType = AttackType.UNARMED_PUNCH;

  @Getter
  @Setter
  private WeaponSpecial weaponSpecial;

  @Getter
  @Setter
  private boolean insertItem;

  public int lastMessage = 1;

  @Getter
  private int headIcon = -1;
  @Getter
  @Setter
  private int combatLevel;
  @Getter
  private Appearance appearance = Player.DEFAULT_APPEARANCE;
  @Getter
  @Setter
  private PlayerRights rights = PlayerRights.PLAYER;

  @Getter
  @Setter
  private PlayerChannel session;

  @Getter
  @Setter
  private String username;

  @Getter
  @Setter
  private String password;
  
  @Getter @Setter
  private int uid;

  @Getter
  @Setter
  private int runEnergy = 100, specialAmount = 100, runRestore;

  private int wildernessLevel;
  private boolean inWilderness;
  private boolean inMultiCombat;

  @Getter
  @Setter
  private boolean withdrawAsNote;

  public static final AttributeKey<Boolean> ACCEPT_AID_KEY =
      AttributeKey.valueOf("accept_aid", true);
  public static final AttributeKey<Boolean> ACTIVE_KEY = AttributeKey.valueOf("active", false);
  public static final AttributeKey<Boolean> AUTO_RETALIATE_KEY =
      AttributeKey.valueOf("auto_retaliate", true);
  public static final AttributeKey<Boolean> BANKING_KEY = AttributeKey.valueOf("banking", false);
  public static final AttributeKey<Boolean> CHAT_EFFECTS_KEY =
      AttributeKey.valueOf("chat_effects", true);
  public static final AttributeKey<Boolean> DEBUG_KEY = AttributeKey.valueOf("debug", false);
  public static final AttributeKey<Boolean> DEBUG_NETWORK_KEY =
      AttributeKey.valueOf("debug_network", false);
  public static final AttributeKey<Boolean> DISCONNECTED_KEY =
      AttributeKey.valueOf("disconnected", false);
  public static final AttributeKey<Boolean> LOGOUT_KEY = AttributeKey.valueOf("logout", false);
  public static final AttributeKey<Boolean> MUSIC_KEY = AttributeKey.valueOf("music", true);
  public static final AttributeKey<Boolean> NEW_PLAYER_KEY =
      AttributeKey.valueOf("new_player", false);
  public static final AttributeKey<Boolean> MOUSE_BUTTON_KEY =
      AttributeKey.valueOf("mouse_button", false);
  public static final AttributeKey<Boolean> SAVE_KEY = AttributeKey.valueOf("save", false);
  public static final AttributeKey<Boolean> SHOPPING_KEY = AttributeKey.valueOf("shopping", false);
  public static final AttributeKey<Boolean> SOUND_KEY = AttributeKey.valueOf("sound", true);
  public static final AttributeKey<Boolean> SPLIT_CHAT_KEY =
      AttributeKey.valueOf("split_chat_key", true);
  public static final AttributeKey<Boolean> CHANGING_APPEARANCE_KEY =
      AttributeKey.valueOf("changing_appearance_key", false);

  public static final AttributeKey<Volume> AREA_SOUND_VOLUME_KEY =
      AttributeKey.valueOf("area_sound_volume", Volume.NORMAL);
  public static final AttributeKey<Volume> MUSIC_VOLUME_KEY =
      AttributeKey.valueOf("music_volume", Volume.NORMAL);
  public static final AttributeKey<Volume> SOUND_EFFECT_VOLUME_KEY =
      AttributeKey.valueOf("sound_effect_volume", Volume.NORMAL);

  public static final AttributeKey<Brightness> BRIGHTNESS_KEY =
      AttributeKey.valueOf("brightness", Brightness.NORMAL);

  // actual player
  public Player(final PlayerChannel session) {
    super(Player.DEFAULT_SPAWN);
    this.session = session;
  }

  // bots
  public Player(String username, Position location) {
    super(location);
    this.username = username;
  }

  public void createAttributes() {
    attr.put(ACCEPT_AID_KEY, true);
    attr.put(ACTIVE_KEY, false);
    attr.put(AREA_SOUND_VOLUME_KEY, Volume.NORMAL);
    attr.put(AUTO_RETALIATE_KEY, true);
    attr.put(BANKING_KEY, false);
    attr.put(BRIGHTNESS_KEY, Brightness.NORMAL);
    attr.put(CHAT_EFFECTS_KEY, true);
    attr.put(DEBUG_KEY, false);
    attr.put(DEBUG_NETWORK_KEY, false);
    attr.put(DISCONNECTED_KEY, false);
    attr.put(LOGOUT_KEY, false);
    attr.put(SAVE_KEY, false);
    attr.put(SHOPPING_KEY, false);
    attr.put(SOUND_KEY, true);
    attr.put(SOUND_EFFECT_VOLUME_KEY, Volume.NORMAL);
    attr.put(SPLIT_CHAT_KEY, true);
    attr.put(MOUSE_BUTTON_KEY, false);
    attr.put(MUSIC_KEY, true);
    attr.put(MUSIC_VOLUME_KEY, Volume.NORMAL);
    attr.put(NEW_PLAYER_KEY, false);
    attr.put(Movement.RUNNING_KEY, true);
    attr.put(Movement.LOCK_MOVEMENT, false);
  }

  @Override
  public void onTick() {

    if (combat.getCombatDelay().elapsed() >= 5_000) {
      combat.getCombatDelay().reset();
    }

    handleRunRestore();

    combatPrayer.drain();
  }

  @Override
  public boolean canLogout() {
    return true;
  }

  public void logout() {
    if (!canLogout()) {
      return;
    }

    post(new LogoutEvent(this));
  }

  public void onDeregister() {
    try {
      save();
    } catch (IOException ex) {
      logger.log(Level.SEVERE, String.format("[player= %s] could not be saved.", username), ex);      
    }
    queuePacket(new LogoutPlayerPacket());
    session.getChannel().close();
    World.deregister(this);
    logger.info(String.format("[DEREGISTERED]: [host= %s]", session.getHostAddress()));
  }

  public synchronized boolean save() throws IOException {
    return new PlayerDetails(this).save() && new PlayerContainer(this).save();
  }

  @Override
  public boolean canTeleport() {
    return true;
  }

  @Override
  public boolean canClickButton() {
    return true;
  }

  @Override
  public boolean canTrade() {
    return true;
  }

  @Override
  public boolean canDuel() {
    return false;
  }

  @Override
  public boolean canAttackMob(Npc mob) {
    return true;
  }

  @Override
  public boolean canAttackPlayer(Player player) {
    return false;
  }

  @Override
  public boolean canClickMob(Npc mob) {
    return true;
  }

  @Override
  public boolean canClickObject(GameObject object) {
    return true;
  }

  @Override
  public boolean canDrink() {
    return true;
  }

  @Override
  public boolean canEat() {
    return true;
  }

  @Override
  public boolean canDrop() {
    return true;
  }

  @Override
  public boolean canMove() {
    return true;
  }

  @Override
  public boolean canPickup(Item item) {
    return true;
  }

  @Override
  public boolean canSave() {
    return true;
  }

  @Override
  public boolean canPray() {
    return true;
  }

  @Override
  public boolean canTalk() {
    return true;
  }

  @Override
  public boolean canUnequip(Item item) {
    return true;
  }

  @Override
  public boolean canUseSpecial() {
    return true;
  }

  @Override
  public void onDeath() {

  }

  @Override
  public void onMovement() {
    displayWalkableInterfaces();

    handleRunEnergy();
  }

  @Override
  public int size() {
    return 1;
  }

  @Override
  public void preUpdate() {
    // first handle the packets
    session.handleQueuedPackets();

    // second movement
    movement.handleEntityMovement();

    // lastly anything else before the npc is updated
    onTick();
  }

  @Override
  public void update() {
    synchronized (this) {
      flushPacket(new UpdatePlayerPacket());
      flushPacket(new UpdateNpcPacket());
    }
  }

  @Override
  public void postUpdate() {
    getUpdateFlags().clear();
    getAnimations().clear();
    getGraphics().clear();
    setRegionChange(false);
    setTeleporting(false);
    getSession().flush();
  }

  @Override
  public int getCurrentHealth() {
    return getSkills().getLevel(Skill.HITPOINTS);
  }

  @Override
  public int getMaximumHealth() {
    return getSkills().getMaxLevel(Skill.HITPOINTS);
  }

  public void displayWalkableInterfaces() {
    if (Area.inWilderness(this)) {
      int calculateY = this.getPosition().getY() > 6400 ? super.getPosition().getY() - 6400
          : super.getPosition().getY();
      wildernessLevel = (((calculateY - 3520) / 8) + 1);
      if (!inWilderness) {
        queuePacket(new DisplayWalkableWidgetPacket(197));
        queuePacket(new SetPlayerOptionPacket(PlayerOption.ATTACK));
        inWilderness = true;
      }
      queuePacket(new SetWidgetStringPacket("@yel@Level: " + wildernessLevel, 199));
    } else if (inWilderness) {
      queuePacket(new SetPlayerOptionPacket(PlayerOption.ATTACK, true));
      queuePacket(new DisplayWalkableWidgetPacket(-1));
      inWilderness = false;
      wildernessLevel = 0;
    }
    if (Area.inMultiCombat(this)) {
      if (!inMultiCombat) {
        queuePacket(new DisplayMultiIconPacket(false));
        inMultiCombat = true;
      }
    } else {
      queuePacket(new DisplayMultiIconPacket(true));
      inMultiCombat = false;
    }
  }

  /**
   * Moves a {@code player} to a target {@code location.
   *
   * @param player The player that is being moved.
   *
   * @param oosition The location the player will be sent to.
   */
  public void move(Position oosition) {
    setLastPosition(position.copy());
    setPosition(new Position(oosition.copy()));
    setTeleporting(true);
    getMovement().reset();
    getUpdateFlags().add(UpdateFlag.APPEARANCE);
  }

  private void handleRunRestore() {
    if (attr.get(Movement.RUNNING_KEY) && movement.isMoving()) {
      return;
    }

    setRunRestore(getRunRestore() + 1);

    if (getRunRestore() == 3) {
      setRunRestore(0);

      int energy = getRunEnergy() + 1;

      if (energy > 100) {
        energy = 100;
      }

      setRunEnergy(energy);
      queuePacket(new SetRunEnergyPacket());
    }
  }

  private void handleRunEnergy() {
    if (!attr.get(Movement.RUNNING_KEY)) {
      return;
    }

    if (getRunEnergy() <= 0) {
      attr.put(Movement.RUNNING_KEY, false);
      queuePacket(new SetWidgetConfigPacket(152, 0));
    } else {
      setRunEnergy(getRunEnergy() - 1);
      queuePacket(new SetRunEnergyPacket());
    }
  }

  /**
   * Posts an event to this world's event provider.
   *
   * @param event The event to post.
   */
  public <E extends Event> void post(E event) {
    World.post(this, event);
  }

  public String getHostAddress() {
    return session.getHostAddress();
  }

  public long getLongUsername() {
    return StringUtils.stringToLong(username);
  }

  public void setAppearance(Appearance appearance) {
    this.appearance = appearance;
    getUpdateFlags().add(UpdateFlag.APPEARANCE);
  }

  public void setHeadIcon(int headIcon) {
    this.headIcon = headIcon;
    getUpdateFlags().add(UpdateFlag.APPEARANCE);
  }

  @Override
  public void dealDamage(Mob attacker, Hit hit) {
    if (getCurrentHealth() - hit.getDamage() <= 0) {
      hit.setDamage(getCurrentHealth());
    }

    getSkills().setLevel(Skill.HITPOINTS, getCurrentHealth() - hit.getDamage());

    hitQueue.add(hit);
    getUpdateFlags().add(UpdateFlag.HIT);
  }

  /**
   * Queues a packet to be processed in sequence.
   * 
   * @param out The packet to queue.
   */
  public void queuePacket(final Sendable out) {
    if (this instanceof StressBot) {
      return;
    }

    this.session.queue(out);
  }

  /**
   * Sends a packet to the client immediately.
   * 
   * @note This should never be used only by player update and npc update packet. All other packets
   *       can be queued.
   * 
   * @param out The packet to send.
   */
  private void flushPacket(final Sendable out) {
    this.session.flush(out);
  }

  @Override
  public EntityType type() {
    return EntityType.PLAYER;
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

}
