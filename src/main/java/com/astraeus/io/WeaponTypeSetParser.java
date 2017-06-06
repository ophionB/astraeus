package com.astraeus.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.astraeus.game.world.entity.mob.combat.def.WeaponTypeSet;
import com.astraeus.util.GsonObjectParser;
import com.google.gson.Gson;

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
