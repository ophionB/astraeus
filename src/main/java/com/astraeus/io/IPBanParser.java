package com.astraeus.io;

import java.io.IOException;
import java.util.Scanner;

import com.astraeus.game.world.World;
import com.astraeus.util.TextFileParser;

public final class IPBanParser extends TextFileParser {

  public IPBanParser() {
    super("./data/punishment/ip_bans");
  }

  @Override
  public void parse(Scanner reader) throws IOException {
    String ip = reader.nextLine();      
    
    World.getIpBans().add(ip);
  }

}
