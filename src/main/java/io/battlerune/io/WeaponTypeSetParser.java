package io.battlerune.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;

import io.battlerune.game.model.entity.mob.combat.def.WeaponTypeSet;
import io.battlerune.util.GsonObjectParser;

public final class WeaponTypeSetParser extends GsonObjectParser<WeaponTypeSet> {

  public WeaponTypeSetParser() {
    super("./data/equipment/weapon_type_set");
  }

  @Override
  public WeaponTypeSet[] deserialize(Gson gson, FileReader reader) throws IOException {
    return gson.fromJson(reader, WeaponTypeSet[].class);
  }

  @Override
  public void onRead(WeaponTypeSet[] array) throws IOException {
    Arrays.stream(array)
        .forEach(it -> WeaponTypeSet.definition.put(it.getType(), it.getAttackTypes()));
  }

}
