package com.astraeus.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.astraeus.game.world.entity.mob.combat.def.WeaponSpecial;
import com.astraeus.util.GsonObjectParser;
import com.google.gson.Gson;

public final class WeaponSpecialParser extends GsonObjectParser<WeaponSpecial> {

  public WeaponSpecialParser() {
    super("./data/equipment/weapon_specials");
  }

  @Override
  public WeaponSpecial[] deserialize(Gson gson, FileReader reader) throws IOException {
    return gson.fromJson(reader, WeaponSpecial[].class);
  }

  @Override
  public void onRead(WeaponSpecial[] array) throws IOException {
    Arrays.stream(array).forEach(WeaponSpecial.definitions::add);
  }

}
