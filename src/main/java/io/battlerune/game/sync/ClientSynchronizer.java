package io.battlerune.game.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.MobList;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.sync.task.MobUpdateTask;
import io.battlerune.game.sync.task.PostMobUpdateTask;
import io.battlerune.game.sync.task.PreMobUpdateTask;

/**
 * The class that synchronizes player's clients with the server.
 * 
 * @author Vult-R
 */
public final class ClientSynchronizer {

  /**
   * The {@link ExecutorService} that will be used for synchronized tasks.
   */
  protected static final ExecutorService executor =
      Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

  /**
   * The phaser that will help keep our server in sync.
   */
  private final Phaser phaser = new Phaser(1);

  /**
   * Synchronizes the server with the client.
   */
  public void synchronize() {

    MobList<Player> players = World.getPlayers();
    MobList<Npc> npcs = World.getNpcs();

    phaser.bulkRegister(players.size());
    players.forEach(player -> executor.submit(new PreMobUpdateTask<Player>(player, phaser)));
    phaser.arriveAndAwaitAdvance();

    phaser.bulkRegister(npcs.size());
    npcs.forEach(npc -> executor.submit(new PreMobUpdateTask<Npc>(npc, phaser)));
    phaser.arriveAndAwaitAdvance();

    phaser.bulkRegister(players.size());
    players.forEach(player -> executor.submit(new MobUpdateTask<Player>(player, phaser)));
    phaser.arriveAndAwaitAdvance();

    phaser.bulkRegister(players.size());
    players.forEach(player -> executor.submit(new PostMobUpdateTask<Player>(player, phaser)));
    phaser.arriveAndAwaitAdvance();

    phaser.bulkRegister(npcs.size());
    npcs.forEach(npc -> executor.submit(new PostMobUpdateTask<Npc>(npc, phaser)));
    phaser.arriveAndAwaitAdvance();

  }

}
