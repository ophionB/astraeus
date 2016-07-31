package astraeus.service;

import astraeus.game.model.World;

/**
 * The {@link GameService} sequencer implementation.
 * 
 * @author Vult-R
 */
public final class GameServiceSequencer extends GameService {
	
	public static int tick = 0;

	@Override
	public void runGameLoop() {
		
		World.world.dequeueLogin();

		long start = System.currentTimeMillis();
		
		World.world.getTasks().runTaskIteration();
		
		synchronizer.synchronize();

		long end = System.currentTimeMillis();

		System.out.println(end - start + " ms");
		
		World.world.dequeueLogout();
		
		GameServiceSequencer.tick++;

	}

}
