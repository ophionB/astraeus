package com.astraeus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.astraeus.game.world.World;
import com.astraeus.io.EquipmentDefinitionParser;
import com.astraeus.io.GlobalObjectParser;
import com.astraeus.io.IPBanParser;
import com.astraeus.io.ItemDefinitionParser;
import com.astraeus.io.NpcCombatDefinitionParser;
import com.astraeus.io.NpcDefinitionParser;
import com.astraeus.io.NpcDropParser;
import com.astraeus.io.NpcSpawnParser;
import com.astraeus.io.PacketSizeParser;
import com.astraeus.io.WeaponDefinitionParser;
import com.astraeus.io.WeaponSpecialParser;
import com.astraeus.io.WeaponTypeSetParser;
import com.astraeus.net.channel.ChannelPiplineInitializer;
import com.astraeus.net.packet.IncomingPacketHandlerRegistration;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetector.Level;

/**
 * The bootstrap that will prepare the game and network.
 * 
 * @author Vult-R
 */
public final class Bootstrap {

  /**
   * The single logger for this class.
   */
  public static final Logger logger = Logger.getLogger(Bootstrap.class.getName());

  /**
   * The {@link ExecutorService} that will run the startup services.
   */
  private final ExecutorService serviceLoader = Executors.newSingleThreadExecutor(
      new ThreadFactoryBuilder().setNameFormat("ServiceLoaderThread").build());

  /**
   * The engine that manages the games logic.
   */
  private final GameEngine service = new GameEngine();
  
  /**
   * The world to setup.
   */
  private final World world;
  
  /**
   * Creates a new {@link Bootstrap}.
   * 
   * @param world
   *        The world to setup.
   */
  public Bootstrap(World world) {
    this.world = world;
  }

  /**
   * Builds the game by executing any startup services, and starting the game loop.
   * 
   * @return The instance of this bootstrap.
   */
  public Bootstrap build() throws Exception {
    logger.info("Unpacking game resources...");
    // load and cache data
    executeStartupServices();

    serviceLoader.shutdown();

    if (!serviceLoader.awaitTermination(15, TimeUnit.MINUTES)) {
      throw new IllegalStateException("The background service load took too long!");
    }

    logger.info("Preparing game engine...");

    service.startAsync();

    logger.info("Game Engine has been built");
    return this;
  }

  /**
   * Builds the network by creating the netty server bootstrap and binding to a specified port.
   * 
   * @return The instance of this bootstrap.
   */
  public Bootstrap bind() throws InterruptedException {
    logger.info("Building network");
    ResourceLeakDetector.setLevel(Level.DISABLED);
    EventLoopGroup loopGroup = new NioEventLoopGroup();

    ServerBootstrap bootstrap = new ServerBootstrap();

    bootstrap.group(loopGroup).channel(NioServerSocketChannel.class)
        .childHandler(new ChannelPiplineInitializer()).bind(43593 + world.getId()).syncUninterruptibly();

    Server.serverStarted = true;
    logger.info(String.format("World %d has been bound to port %d", world.getId(), world.getPort()));    
    return this;
  }

  /**
   * Executes external files to be used in game.
   */
  private void executeStartupServices() {

    logger.info("Initializing packets...");
    serviceLoader.execute(() -> {
      new PacketSizeParser().run();
      new IncomingPacketHandlerRegistration();
    });

    logger.info("Loading startup files..");
    serviceLoader.execute(() -> {
      new GlobalObjectParser().run();
      new ItemDefinitionParser().run();
      new NpcDefinitionParser().run();
      new NpcSpawnParser().run();
      new IPBanParser().run();
      new EquipmentDefinitionParser().run();
      new WeaponDefinitionParser().run();
      new WeaponTypeSetParser().run();
      new WeaponSpecialParser().run();
      new NpcCombatDefinitionParser().run();
      new NpcDropParser().run();
    });

    logger.info("Loading plugins");
    serviceLoader.execute(() -> World.getPluginService().load());

  }

}
