package astraeus.game.sync;

import astraeus.game.model.World;
import astraeus.game.model.entity.mob.MobList;
import astraeus.game.model.entity.mob.npc.Npc;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.sync.task.MobUpdateTask;
import astraeus.game.sync.task.PostMobUpdateTask;
import astraeus.game.sync.task.PreMobUpdateTask;
import astraeus.service.GameService;

import java.util.concurrent.Phaser;

/**
 * The class that synchronizes player's clients with the server.
 * 
 * @author Vult-R
 */
public final class ClientSynchronizer {

	/**
	 * The service that runs the game.
	 */
	private final GameService service;

	/**
	 * The phaser that will help keep our server in sync.
	 */
	private final Phaser phaser = new Phaser(1);

	/**
	 * Creates a new {@link ClientSynchronizer}.
	 * 
	 * @param service
	 *            The service that runs the game.
	 */
	public ClientSynchronizer(GameService service) {
		this.service = service;
	}

	/**
	 * Synchronizes the server with the client.
	 */
	public void synchronize() {
		
		MobList<Player> players = World.world.getPlayers();
		MobList<Npc> npcs = World.world.getMobs();
		
		players.forEach(player -> service.getExecutor().submit(new PreMobUpdateTask<Player>(player, phaser)));
		phaser.arriveAndAwaitAdvance();
		
		npcs.forEach(npc -> service.getExecutor().submit(new PreMobUpdateTask<Npc>(npc, phaser)));
		phaser.arriveAndAwaitAdvance();
		
		players.forEach(player -> service.getExecutor().submit(new MobUpdateTask<Player>(player, phaser)));
		phaser.arriveAndAwaitAdvance();

		players.forEach(player -> service.getExecutor().submit(new PostMobUpdateTask<Player>(player, phaser)));
		phaser.arriveAndAwaitAdvance();
		
		npcs.forEach(npc -> service.getExecutor().submit(new PostMobUpdateTask<Npc>(npc, phaser)));
		phaser.arriveAndAwaitAdvance();
		
	}

}
