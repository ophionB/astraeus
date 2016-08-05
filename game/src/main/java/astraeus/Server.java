package astraeus;

import java.util.logging.Logger;

import astraeus.game.model.World;
import astraeus.util.LoggerUtils;
import astraeus.util.Stopwatch;
import lombok.Getter;

/**
 * The core class of the server.
 *
 * @author Vult-R
 */
public final class Server {

  /**
   * The single logger for this class.
   */
  private static final Logger logger = LoggerUtils.getLogger(Server.class);

  /**
   * To check if the server needs to be updated.
   */
  public static boolean updateServer = false;

  /**
   * Determines if the server has started.
   */
  public static boolean serverStarted = false;

  /**
   * The elapsed time the server has been running.
   */
  @Getter private static Stopwatch uptime;

  /**
   * The main entry point to the server.
   *
   * @param args The command line arguments.
   *
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    final Stopwatch timer = new Stopwatch().reset();
    
    World world = new World(args.length > 0 ? Integer.parseInt(args[0]) : 1);

    logger.info(String.format("Starting world: %d", world.getId()));
    
    new Bootstrap(world).build().bind();

    uptime = new Stopwatch();    

    logger.info(String.format("World %d initialized. [Took %s ms]", world.getId(), timer.elapsed()));

  }

}
