package io.battlerune.io;

import java.io.IOException;
import java.util.Scanner;

import io.battlerune.game.model.World;
import io.battlerune.util.TextFileParser;

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
