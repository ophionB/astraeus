package com.astraeus.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.astraeus.game.world.entity.mob.npc.NpcDefinition;
import com.astraeus.util.GsonObjectParser;
import com.google.gson.Gson;

public final class NpcDefinitionParser extends GsonObjectParser<NpcDefinition> {

  public NpcDefinitionParser() {
    super("./data/npc/npc_definitions");
  }

  @Override
  public NpcDefinition[] deserialize(Gson gson, FileReader reader) throws IOException {
    return gson.fromJson(reader, NpcDefinition[].class);
  }

  @Override
  public void onRead(NpcDefinition[] array) throws IOException {
    Arrays.stream(array).forEach($it -> NpcDefinition.getDefinitions()[$it.getId()] = $it);
  }

}
