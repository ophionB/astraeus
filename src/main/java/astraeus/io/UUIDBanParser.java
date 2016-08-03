package astraeus.io;

import java.io.IOException;
import java.util.Scanner;

import astraeus.game.model.World;
import astraeus.util.TextFileParser;

public class UUIDBanParser extends TextFileParser {

  public UUIDBanParser() {
    super("./data/punishment/uuid_bans");
  }

  @Override
  public void parse(Scanner reader) throws IOException {
    String uuid = reader.nextLine();
    World.world.getBannedUUIDs().add(uuid);
  }

}
