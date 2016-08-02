package astraeus.service;

import java.util.concurrent.*;
import java.util.logging.Logger;

import astraeus.game.model.World;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import astraeus.game.sync.ClientSynchronizer;
import astraeus.util.LoggerUtils;

/**
 * Represents a simple engine that sequentially processes game logic.
 * 
 * @author Vult-R
 */
public class GameService extends AbstractScheduledService {

	/**
	 * The single logger for this class.
	 */
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerUtils.getLogger(GameService.class);

	/**
	 * The synchronizer that will keeps in sync.
	 */
	protected final ClientSynchronizer synchronizer = new ClientSynchronizer(this);

	/**
	 * The rate in which the executor iterates the game loop.
	 */
	private static final int GAME_CYLCE_RATE = 600;
	
	/**
	 * The delay in milliseconds before running the game loop.
	 */
	private static final int GAME_DELAY = 600;

	public static int tick = 0;

	@Override
	public void runOneIteration() {

		long start = System.currentTimeMillis();

		World.world.dequeueLogin();

		World.world.getTasks().runTaskIteration();

		synchronizer.synchronize();

		World.world.dequeueLogout();

		long end = System.currentTimeMillis();

		System.out.println(end - start + " ms");

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
