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
		
		World.world.getTasks().process();
		
		@SuppressWarnings("unused")
		long start = System.currentTimeMillis();
		
		synchronizer.synchronize();
		
		@SuppressWarnings("unused")
		long end = System.currentTimeMillis();
		
		//System.out.println("cycle: " + (end - start) + " ms");				
		
		World.world.dequeueLogout();
		
		GameServiceSequencer.tick++;

	}

}
