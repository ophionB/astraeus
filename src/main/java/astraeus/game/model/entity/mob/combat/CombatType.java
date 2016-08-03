package astraeus.game.model.entity.mob.combat;

public enum CombatType {

  MELEE(4), RANGE(4), MAGIC(2);

  private int rate;

  private CombatType(int rate) {
    this.rate = rate;
  }

  public int getRate() {
    return rate;
  }

}
