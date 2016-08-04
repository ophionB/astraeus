package astraeus.game.model.entity.mob.npc.drop;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.Data;

/**
 * A class which represents a single npc drop.
 * 
 * @author Vult-R https://github.com/Vult-R
 */
@Data
public final class NpcDrop {
  
  public static final double ALWAYS = 1.0;
  
  public static final double ALMOST_ALWAYS = 1/2;
  
  public static final double VERY_COMMON = 1/5;
  
  public static final double COMMON = 1/20;
  
  public static final double UNCOMMON = 1/50;
  
  public static final double VERY_UNCOMMON = 1/100;
  
  public static final double RARE = 1/200;
  
  public static final double VERY_RARE = 1/286;
  
  public static final double EXTREMELY_RARE = 1/500;
  
  public static final double LEGENDARY = 1/900;

  /**
   * The map of npc ids mapped to their potential drops.
   */
  private final static Map<Integer, NpcDrop[]> drops = new HashMap<>();  

  /**
   * The id of the item being dropped.
   */
  private final int itemId;

  /**
   * The minimum amount of this item that can be dropped.
   */
  private final int minAmount;

  /**
   * The maximum amount of this item that can be dropped.
   */
  private int maxAmount;

  /**
   * The rate at which this item drops.
   */
  private final double rate;

  /**
   * Creates a new {@link NpcDrop}.
   * 
   * @param itemId
   *        The id of the item being dropped.
   *        
   * @param minAmount
   *        The minimum amount of this item that can be dropped.
   *        
   * @param maxAmount
   *        The maximum amount of this item that can be dropped.
   *        
   * @param rate
   *        The rate at which this item drops.
   */
  public NpcDrop(int itemId, int minAmount, int maxAmount, double rate) {
    this.itemId = itemId;
    this.minAmount = minAmount;
    this.maxAmount = maxAmount;
    this.rate = rate;
  }

  /**
   * Gets the optional describing the result of looking for a drop.
   * 
   * @param id
   *        The npc id to check.
   *        
   * @return The optional that may contain the array of drops.
   */
  public static Optional<NpcDrop[]> lookup(int id) {
    return Optional.ofNullable(drops.get(id));
  }

  /**
   * Determines if this drop is rare.
   */
  public boolean isFromRareTable() {
    if (rate <= RARE) {
      return true;
    }
    return false;
  }

}
