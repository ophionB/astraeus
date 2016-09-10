package astraeus;

import astraeus.game.model.entity.item.ItemDefinition;
import astraeus.game.model.entity.mob.player.collect.Equipment.EquipmentDefinition;
import astraeus.game.model.entity.mob.player.collect.Equipment.EquipmentType;

public class WeaponDefinitionUpdater {

  public static void main(String[] args) {

  }

  public static int getBlockEmote(EquipmentDefinition def) {

    if (def == null || def.getName() == null) {
      return 424;
    }

    String name = def.getName().toLowerCase();

    if (def.getType() == EquipmentType.SHIELD) {

      if (name.contains("defender")) {
        return 4177;
      } else if (name.contains("2h")) {
        return 7050;
      } else if (name.contains("book") || (name.contains("wand") || (name.contains("staff")))) {
        return 420;
      } else if (name.contains("shield")) {
        return 1156;
      }
    } else if (def.getType() == EquipmentType.WEAPON) {

      switch (def.getId()) {

        case 4755:
          return 2063;
        case 15241:
          return 12156;
        case 13899:
          return 13042;
        case 18355:
          return 13046;
        case 14484:
          return 397;
        case 11716:
          return 12008;
        case 4153:
          return 1666;
        case 4151:
          return 1659;
        case 15486:
          return 12806;
        case 18349:
          return 12030;
        case 18353:
          return 13054;
        case 18351:
          return 13042;

        case 11694:
        case 11698:
        case 11700:
        case 11696:
        case 11730:
          return 7050;

        default:
          return 424;

      }

    }

    return 424;

  }

  public static int getHitDelay(int id) {

    ItemDefinition def = ItemDefinition.lookup(id);

    if (def == null || def.getName() == null) {
      return 2;
    }

    String name = def.getName();

    if (name.contains("dart")) {
      return 3;
    } else if (name.contains("knife") || name.contains("javelin") || name.contains("thrownaxe")) {
      return 3;
    } else if (name.contains("cross") || name.contains("c'bow")) {
      return 4;
    } else if (name.contains("bow")) {
      return 4;
    }

    switch (id) {
      case 6522: // Toktz-xil-ul
        return 3;

      case 10887:
        return 3;

      case 10034:
      case 10033:
        return 3;

      default:
        return 2;
    }
  }

  public static int getAttackDelay(ItemDefinition def) {

    if (def == null || def.getName() == null) {
      return 5;
    }

    String name = def.getName();

    switch (def.getId()) {
      case 11235:
        return 9;
      case 11730:
        return 4;
      case 6528:
        return 7;
      case 10033:
      case 10034:
        return 5;
      case 9703:
        return 2;
    }

    if (name.endsWith("greataxe"))
      return 7;
    else if (name.equals("torags hammers"))
      return 5;
    else if (name.equals("barrelchest anchor"))
      return 7;
    else if (name.equals("guthans warspear"))
      return 5;
    else if (name.equals("veracs flail"))
      return 5;
    else if (name.equals("ahrims staff"))
      return 6;
    else if (name.contains("staff")) {
      if (name.contains("zamarok") || name.contains("guthix") || name.contains("saradomian")
          || name.contains("slayer") || name.contains("ancient"))
        return 4;
      else
        return 5;
    } else if (name.contains("bow")) {
      if (name.contains("composite") || name.equals("seercull"))
        return 5;
      else if (name.contains("aril"))
        return 4;
      else if (name.contains("Ogre"))
        return 8;
      else if (name.contains("short") || name.contains("hunt") || name.contains("sword"))
        return 4;
      else if (name.contains("long") || name.contains("crystal"))
        return 6;
      else if (name.contains("'bow"))
        return 7;

      return 5;
    } else if (name.contains("dagger"))
      return 4;
    else if (name.contains("godsword") || name.contains("2h"))
      return 6;
    else if (name.contains("longsword"))
      return 5;
    else if (name.contains("sword"))
      return 4;
    else if (name.contains("scimitar"))
      return 4;
    else if (name.contains("mace"))
      return 5;
    else if (name.contains("battleaxe"))
      return 6;
    else if (name.contains("pickaxe"))
      return 5;
    else if (name.contains("thrownaxe"))
      return 5;
    else if (name.contains("axe"))
      return 5;
    else if (name.contains("warhammer"))
      return 6;
    else if (name.contains("2h"))
      return 7;
    else if (name.contains("spear"))
      return 5;
    else if (name.contains("claw"))
      return 4;
    else if (name.contains("halberd"))
      return 7;
    else if (name.equals("granite maul"))
      return 7;
    else if (name.equals("toktz-xil-ak"))// sword
      return 4;
    else if (name.equals("tzhaar-ket-em"))// mace
      return 5;
    else if (name.equals("tzhaar-ket-om"))// maul
      return 7;
    else if (name.equals("toktz-xil-ek"))// knife
      return 4;
    else if (name.equals("toktz-xil-ul"))// rings
      return 4;
    else if (name.equals("toktz-mej-tal"))// staff
      return 6;
    else if (name.contains("whip"))
      return 4;
    else if (name.contains("dart"))
      return 3;
    else if (name.contains("knife"))
      return 3;
    else if (name.contains("javelin"))
      return 6;
    return 5;
  }



}
