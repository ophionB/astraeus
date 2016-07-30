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
		
		World.world.getTasks().runTaskIteration();
		
		synchronizer.synchronize();		
		
		World.world.dequeueLogout();
		
		GameServiceSequencer.tick++;

	}

}
