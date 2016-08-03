package astraeus;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.AbstractScheduledService;

import astraeus.game.model.World;
import astraeus.game.sync.ClientSynchronizer;

/**
 * Represents the main game processor or engine that sequentially processes game logic.
 * 
 * @author Vult-R
 */
public final class GameEngine extends AbstractScheduledService {

  /**
   * The synchronizer that will keeps in sync.
   */
  private final ClientSynchronizer synchronizer = new ClientSynchronizer();

  /**
   * The rate in which the executor iterates the game loop.
   */
  private static final int GAME_CYLCE_RATE = 600;

  /**
   * The delay in milliseconds before running the game loop.
   */
  private static final int GAME_DELAY = 600;

  /**
   * The number of times the server has ran the #runOneIteration method.
   */
  public static int tick = 0;

  @Override
  public void runOneIteration() {

    @SuppressWarnings("unused")
    long start = System.currentTimeMillis();

    World.world.dequeueLogin();

    World.world.getTasks().runTaskIteration();

    synchronizer.synchronize();

    World.world.dequeueLogout();

    @SuppressWarnings("unused")
    long end = System.currentTimeMillis();

    // System.out.println(end - start + " ms");

    tick++;

    if (tick >= 1000) {
      tick = 0;
    }

  }

  /**
   * Schedules the game service to run the main game loop.
   */
  @Override
  protected Scheduler scheduler() {
    return Scheduler.newFixedRateSchedule(GAME_DELAY, GAME_CYLCE_RATE, TimeUnit.MILLISECONDS);
  }

}
