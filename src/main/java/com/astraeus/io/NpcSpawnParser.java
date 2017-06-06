package com.astraeus.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.astraeus.game.world.entity.mob.npc.NpcSpawn;
import com.astraeus.game.world.entity.mob.npc.Npcs;
import com.astraeus.util.GsonObjectParser;
import com.google.gson.Gson;

public final class NpcSpawnParser extends GsonObjectParser<NpcSpawn> {

  public NpcSpawnParser() {
    super("./data/npc/npc_spawns");
  }

  @Override
  public NpcSpawn[] deserialize(Gson gson, FileReader reader) throws IOException {
    return gson.fromJson(reader, NpcSpawn[].class);
  }

  @Override
  public void onRead(NpcSpawn[] array) throws IOException {
    Arrays.stream(array).forEach($it -> Npcs.createSpawn($it));
  }

}
