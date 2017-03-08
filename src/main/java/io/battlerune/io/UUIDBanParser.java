package io.battlerune.io;

import java.io.IOException;
import java.util.Scanner;

import io.battlerune.game.model.World;
import io.battlerune.util.TextFileParser;

public class UUIDBanParser extends TextFileParser {

  public UUIDBanParser() {
    super("./data/punishment/uuid_bans");
  }

  @Override
  public void parse(Scanner reader) throws IOException {
    String uuid = reader.nextLine();
    World.getBannedUUIDs().add(uuid);
  }

}
