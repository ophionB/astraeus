package astraeus.io;

import java.io.IOException;
import java.util.Scanner;

import astraeus.game.model.World;
import astraeus.util.TextFileParser;

/**
 * Parses the ip bans
 *
 * @author Seven
 */
public final class IPBanParser extends TextFileParser {

  /**
   * Creates a new {@link IPBanParser}.
   */
  public IPBanParser() {
    super("./data/punishment/ip_bans");
  }

  @Override
  public void parse(Scanner reader) throws IOException {
    String ip_bans = reader.nextLine();
    World.getIpBans().add(ip_bans);
  }

}
