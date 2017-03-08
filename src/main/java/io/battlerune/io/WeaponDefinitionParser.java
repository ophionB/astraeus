package io.battlerune.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

import io.battlerune.game.model.entity.mob.combat.def.WeaponDefinition;
import io.battlerune.util.GsonObjectParser;

public final class WeaponDefinitionParser extends GsonObjectParser<WeaponDefinition> {

  public WeaponDefinitionParser() {
    super("./data/equipment/weapon_definitions");
  }

  @Override
  public WeaponDefinition[] deserialize(Gson gson, FileReader reader) throws IOException {
    return gson.fromJson(reader, WeaponDefinition[].class);
  }

  @Override
  public void onRead(WeaponDefinition[] array) throws IOException {
    Arrays.stream(array).forEach(it -> WeaponDefinition.definitions.put(it.getId(), it));
  }

}
