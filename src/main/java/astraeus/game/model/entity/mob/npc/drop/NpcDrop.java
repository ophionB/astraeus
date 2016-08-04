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
  
  public static final double ALWAYS = 1.0D;
  
  public static final double ALMOST_ALWAYS = 1/2D;
  
  public static final double VERY_COMMON = 1/5D;
  
  public static final double COMMON = 1/20D;
  
  public static final double UNCOMMON = 1/50D;
  
  public static final double VERY_UNCOMMON = 1/100D;
  
  public static final double RARE = 1/200D;
  
  public static final double VERY_RARE = 1/286D;
  
  public static final double EXTREMELY_RARE = 1/500D;
  
  public static final double LEGENDARY = 1/900D;
  
  /**
   * The map of npc ids mapped to their potential drops.
   */
  public final static Map<Integer, Drop[]> npcDrops = new HashMap<>();  
  
  @Data
  public static final class Drop {
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
     * @param rate
     *        The rate at which this item drops.
     */
    public Drop(int itemId, double rate) {
      this(itemId, 1, 1, rate);
    }

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
    public Drop(int itemId, int minAmount, int maxAmount, double rate) {
      this.itemId = itemId;
      this.minAmount = minAmount;
      this.maxAmount = maxAmount;
      this.rate = rate;
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

  /**
   * The id of the npc that contains these drops.
   */
  private final int npcId;
  
  /**
   * The array of drops that are associated with this npc.
   */
  private final Drop[] drops;
  
  /**
   * Creates a new {@link NpcDrop}.
   * 
   * @param npcId
   *        The id that these drops belong to.
   *        
   * @param drops
   *        The drops associated with this npc.
   */
  public NpcDrop(int npcId, Drop[] drops) {
    this.npcId = npcId;
    this.drops= drops;
  }

  /**
   * Gets the optional describing the result of looking for a drop.
   * 
   * @param id
   *        The npc id to check.
   *        
   * @return The optional that may contain the array of drops.
   */
  public static Optional<Drop[]> lookup(int id) {
    return Optional.ofNullable(npcDrops.get(id));
  }

}
