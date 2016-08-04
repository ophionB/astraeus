package astraeus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition.AggressiveBonus;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition.CombatBonus;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition.DefensiveBonus;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition.ImmuneType;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition.NpcCombatBonus;
import astraeus.game.model.entity.mob.combat.def.NpcCombatDefinition.OtherBonus;
import astraeus.game.model.entity.mob.player.skill.SkillData;

public class NpcCombatDefinitionUpdater {

  public static void main(String[] args) throws IOException {
    
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      
     NpcCombatDefinition[] def = new NpcCombatDefinition[]{new NpcCombatDefinition(9, "Guard", 22, false, false, 6, new int[]{0}, 4, 20, NpcCombatDefinitionUpdater.npcDefenceAnim(9), NpcCombatDefinitionUpdater.getDeathAnimation(9), NpcCombatDefinitionUpdater.getAttackAnimations(9), ImmuneType.NONE, new SkillData[]{SkillData.MAGIC}, new NpcCombatBonus(new CombatBonus(19, 18, 14, 1, 1), new AggressiveBonus(4, 0, 0, 0, 0), new DefensiveBonus(18, 25, 19, -4, 20), new OtherBonus(5, 0, 4)))};
  
     String s = gson.toJson(def);
     
     try(FileWriter writer = new FileWriter(new File("./npc_combat_definitions.json"))) {
       writer.write(s);
     }
  }
  
  public static int[] getHitDelay(int id) {    
    switch (id) {
    case 2881:
    case 2882:
    case 3200:
    case 2892:
    case 2894:
        return new int[]{3};

    case 2743:
    case 2631:
    case 2558:
    case 2559:
    case 2560:
        return new int[]{3};

    case 2745:        
        return new int[]{2, 5, 5};

    case 2025:
        return new int[]{4};
        
    case 2028:
        return new int[]{3};

    default:
        return new int[]{2};
        
    }
}
  
  public static int getDeathAnimation(int id) {    
    switch (id) {
      
    case 871:// Ogre Shaman
        return 361;
        
    case 438:
    case 439:
    case 440:
    case 441:
    case 442: // Tree spirit
    case 443:
        return 97;
    case 391:
    case 392:
    case 393:
    case 394:
    case 395:// river troll
    case 396:
        return 287;
    case 413:
    case 414:
    case 415:
    case 416:
    case 417:// rock golem
    case 418:
        return 156;
    case 419:// zombie
    case 420:
    case 421:
    case 422:
    case 423:
    case 424:
        return 5569;
        // begin new updates
    case 112: // moss
        return 4659;
    case 103: // ghost
        return 5542;
    case 78: // bats
        return 4917;
        // end
    case 6223:
    case 6225:
    case 6227:
        return 6956;
    case 6248:
        return 6377;
    case 6250:
        return 7016;
    case 6261:
    case 6263:
    case 6265:
        return 6156;
    case 6204:
    case 6206:
    case 6208:
        return 6946;
    case 6142:
        return 1;
    case 6143:
        return 1;
    case 6144:
        return 1;
    case 6145:
        return 1;
    case 1265:// RockCrab
        return 1314;
    case 914:// Battle Mage
        return 196;
    case 3742:// Ravager
    case 3743:
    case 3744:
    case 3745:
    case 3746:
        return 3916;
    case 3772:// Brawler
    case 3773:
    case 3774:
    case 3775:
    case 3776:
        return 3894;
    case 49:
        return 6576;
    case 6247:
        return 6965;
    case 6203:
        return 6945;
    case 6260:
        return 7062;
    case 6222:
        return 6975;
    case 6267:
        return 357;
    case 6268:
        return 2938;
    case 6269:
        return 4653;
    case 6270:
        return 4653;
    case 6271:
        return 4321;
    case 6272:
        return 4321;
    case 6273:
        return 4321;
    case 6274:
        return 4321;
    case 117:
        return 4651;
    case 1459:
        return 1404;
    case 1612: // banshee
        return 1524;
    case 2559:
    case 2560:
    case 2561:
        return 6956;
    case 2607:
        return 2607;
    case 2627:
        return 2620;
    case 2630:
        return 2627;
    case 2631:
        return 2630;
    case 2738:
        return 2627;
    case 2741:
        return 2638;
    case 2746:
        return 2638;
    case 2743:
        return 2646;
    case 2745:
        return 2654;
    case 3777:
    case 3778:
    case 3779:
    case 3780:
        return -1;
    case 5666:
        return 5898;
    case 3200:
        return 3147;
    case 2035: // spider
        return 146;
    case 2033: // rat
        return 141;
    case 2031: // bloodvel
        return 2073;
    case 1769:
    case 1770:
    case 1771:
    case 1772:
    case 1773:
    case 101: // goblin
        return 6182;
    case 1767:
    case 397:
    case 1766:
    case 1768:
    case 81: // cow
        return 5851;
    case 41: // chicken
        return 57;
    case 1338: // dagannoth
    case 1340:
    case 1342:
        return 1342;
    case 2881:
    case 2882:
    case 2883:
        return 2856;
    case 111: // ice giant
        return 131;
    case 125: // ice warrior
        return 843;
    case 751:// Zombies!!
        return 302;
    case 1626:
    case 1627:
    case 1628:
    case 1629:
    case 1630:
    case 1631:
    case 1632: // turoth!
        return 1597;
    case 1616: // basilisk
        return 1548;
    case 1653: // hand
        return 1590;
    case 82:// demons
    case 83:
    case 84:
        return 67;
    case 1605:// abby spec
        return 1508;
    case 51:// baby drags
    case 52:
    case 1589:
    case 3376:
        return 28;
    case 1610:
    case 1611:
        return 1518;
    case 1618:
    case 1619:
        return 1553;
    case 1620:
    case 1621:
        return 1563;
    case 2783:
        return 2732;
    case 1615:
        return 1538;
    case 1624:
        return 1558;
    case 1613:
        return 1530;
    case 1633:
    case 1634:
    case 1635:
    case 1636:
        return 1580;
    case 1648:
    case 1649:
    case 1650:
    case 1651:
    case 1652:
    case 1654:
    case 1655:
    case 1656:
    case 1657:
        return 1590;
    case 100:
    case 102:
        return 313;
    case 105:
    case 106:
        return 44;
    case 412:
        // case 78:
        return 36;
    case 122:
    case 123:
        return 167;
    case 58:
    case 59:
    case 60:
    case 61:
    case 62:
    case 63:
    case 64:
    case 134:
        return 146;
    case 1153:
    case 1154:
    case 1155:
    case 1156:
    case 1157:
        return 1190;
        // case 103:
    case 104:
        return 5534;
    case 118:
    case 119:
        return 102;
    case 50:// drags
        return 92;
    case 53:
    case 54:
    case 55:
    case 941:
    case 1590:
    case 1591:
    case 1592:
        return 92;
        
    default:
        return 2304;
        
    }
}
  
  public static int[] getAttackAnimations(int id) {    
    switch (id) {
    case 1618:
        return new int[]{1552};
    case 419: // zombie
    case 420:
    case 421:
    case 422:
    case 423:
    case 424:
        return new int[]{5568};
    case 438:
    case 439:
    case 440:
    case 441:
    case 442: // Tree spirit
    case 443:
        return new int[]{94};
    case 391:
    case 392:
    case 393:
    case 394:
    case 395:// river troll
    case 396:
        return new int[]{284};
    case 413:
    case 414:
    case 415:
    case 416:
    case 417:// rock golem
    case 418:
        return new int[]{153};
        
    case 112: // moss
        return new int[]{4658};
        
    case 103: // ghost
        return new int[]{5540};
        
    case 78: // bats
        return new int[]{4915};
        
    case 1612: // banshee
        return new int[]{1523};
        
    case 2783: // dark beast
        return new int[]{2731};
        
    case 6248:
        return new int[]{6376};
        
    case 6250:
        return new int[]{7018};
        
    case 6261:
    case 6263:
    case 6265:
        return new int[]{6154};
        
    case 6204:
    case 6206:
    case 6208:
        return new int[]{6945};
    case 49:
        return new int[]{6579};
    case 6247:
        return new int[]{6964};
    case 6203:
        return new int[]{6945};
    case 6223:
    case 6225:
    case 6227:
        return new int[]{6953};
    case 6222:
        return new int[]{6976};
    case 6267:
        return new int[]{359};
    case 6268:
        return new int[]{2930};
    case 6269:
        return new int[]{4652};
    case 6270:
        return new int[]{4652};
    case 6271:
        return new int[]{4320};
    case 6272:
        return new int[]{4320};
    case 6273:
        return new int[]{4320};
    case 6274:
        return new int[]{4320};
    case 1459:
        return new int[]{1402};
    case 6260:        
        return new int[]{7060, 7063};
        
    case 86:
    case 87:
        return new int[]{4933};
        
    case 871:// Ogre Shaman
    case 5181:// Ogre Shaman
    case 5184:// Ogre Shaman
    case 5187:// Ogre Shaman
    case 5190:// Ogre Shaman
    case 5193:// Ogre Shaman
        return new int[]{359};

    case 2892:
    case 2894:
        return new int[]{2868};
        
    case 2627:
        return new int[]{2621};
    case 2630:
        return new int[]{2625};
    case 2631:
        return new int[]{2633};
    case 2741:
        return new int[]{2637};
    case 2746:
        return new int[]{2637};
    case 2607:
        return new int[]{2611};
    case 2743:// 360
        return new int[]{2647};
    case 5247:
        return new int[]{5411};
    case 13: // wizards
        return new int[]{711};

    case 655:
        return new int[]{5532};

    case 1624:
        return new int[]{1557};

    case 1648:
        return new int[]{1590};

    case 1615: // abby demon
        return new int[]{1537};

    case 1613: // nech
        return new int[]{1528};

    case 1610:
    case 1611: // garg
        return new int[]{1519};

    case 1616: // basilisk
        return new int[]{1546};

        // case 459: //skele
        // return 260;

    case 50:// drags
        return new int[]{80};
    case 53:
    case 54:
    case 55:
    case 941:
    case 1590:
    case 1591:
    case 1592:
        return new int[]{80};
    case 124: // earth warrior
        return new int[]{390};

    case 803: // monk
        return new int[]{422};

    case 52: // baby drag
        return new int[]{25};

    case 58: // Shadow Spider
    case 59: // Giant Spider
    case 60: // Giant Spider
    case 61: // Spider
    case 62: // Jungle Spider
    case 63: // Deadly Red Spider
    case 64: // Ice Spider
    case 134:
        return new int[]{143};

    case 105: // Bear
    case 106:// Bear
        return new int[]{41};

    case 412:
        // case 78:
        return new int[]{30};

    case 2033: // rat
        return new int[]{138};

    case 2031: // bloodworm
        return new int[]{2070};

    case 1769:
    case 1770:
    case 1771:
    case 1772:
    case 1773:
    case 101: // goblin
        return new int[]{6184};

    case 1767:
    case 397:
    case 1766:
    case 1768:
    case 81: // cow
        return new int[]{5849};

    case 21: // hero
        return new int[]{451};

    case 41: // chicken
        return new int[]{55};

    case 9: // guard
    case 32: // guard
    case 20: // paladin
        return new int[]{451};

    case 1338: // dagannoth
    case 1340:
    case 1342:

        return new int[]{1341};

    case 19: // white knight
        return new int[]{406};

    case 110:
    case 111: // ice giant
    case 117:
        return new int[]{4651};

    case 2452:
        return new int[]{1312};

    case 2889:
        return new int[]{2859};

    case 118:
    case 119:
        return new int[]{99};

    case 82:// Lesser Demon
    case 83:// Greater Demon
    case 84:// Black Demon
    case 1472:// jungle demon
        return new int[]{64};

    case 1267:
    case 1265:
        return new int[]{1312};

    case 125: // ice warrior
    case 178:
        return new int[]{451};

    case 1153: // Kalphite Worker
    case 1154: // Kalphite Soldier
    case 1155: // Kalphite guardian
    case 1156: // Kalphite worker
    case 1157: // Kalphite guardian
        return new int[]{1184};

    case 123:
    case 122:
        return new int[]{164};

    case 2028: // karil
        return new int[]{2075};

    case 2025: // ahrim
        return new int[]{729};

    case 2026: // dharok
        return new int[]{2067};

    case 2027: // guthan
        return new int[]{2080};

    case 2029: // torag
        return new int[]{0x814};

    case 2030: // verac
        return new int[]{2062};

    case 2881: // supreme
        return new int[]{2855};

    case 2882: // prime
        return new int[]{2854};

    case 2883: // rex
        return new int[]{2851};
        
    case 5666:      
        return new int[]{5895, 5894, 5896};

    case 3200:
        return new int[]{3146};

    case 2745:        
        return new int[]{2655, 2652, 2656};

    default:
        return new int[]{806};
    }
}
  
  public boolean isAggressive(int id) {    
    switch (id) {
    case 2550:
    case 2551:
    case 2552:
    case 2553:
    case 2558:
    case 2559:
    case 2560:
    case 2561:
    case 2562:
    case 2563:
    case 2564:
    case 2565:
    case 2892:
    case 2894:
    case 2881:
    case 2882:
    case 2883:
    case 2035:
        // GWD
    case 6250:// Npcs That Give ArmaKC
    case 6230:
    case 6231:
    case 6229:
    case 6232:
    case 6240:
    case 6241:
    case 6242:
    case 6233:
    case 6234:
    case 6243:
    case 6244:
    case 6245:
    case 6246:
    case 6238:
    case 6239:
    case 6227:
    case 6625:
    case 6223:
    case 6222: // end of armadyl npcs
    case 122:// Npcs That Give BandosKC
    case 100:// Npcs That Give BandosKC
    case 6278:
    case 6277:
    case 6276:
    case 6283:
    case 6282:
    case 6281:
    case 6280:
    case 6279:
    case 6271:
    case 6272:
    case 6273:
    case 6274:
    case 6269:
    case 6270:
    case 6268:
    case 6265:
    case 6263:
    case 6261:
    case 6260: // end of bandos npcs
    case 6221:
    case 6219:
    case 6220:
    case 6217:
    case 6216:
    case 6215:
    case 6214:
    case 6213:
    case 6212:
    case 6211:
    case 6218:
    case 6208:
    case 6206:
    case 6204:
    case 6203:
    case 6275:
    case 6257:// Npcs That Give SaraKC
    case 6255:
    case 6256:
    case 6258:
    case 6259:
    case 6254:
    case 6252:
    case 6248:
    case 6247:
        return true;
    }
    return false;
}

  public static int npcDefenceAnim(int id) {
    switch (id) {
      case 1338: // dagannoth
      case 1340:
      case 1342:
        return 1340;
      case 100:
        return 6189;
      case 101:
        return 6183;
      case 3835:
        return 6232;
      case 2037:
        return 5489;
      case 5529:
        return 5783;
      case 5219:
      case 5218:
        return 5096;
      case 5235:
        return 5395;
      case 10127:
        return 13170;
      case 10057:
        return 10818;
      case 5904:
        return 6330;
      case 5903:
        return 6346;
      case 9463:
      case 9465:
      case 9467:
        return 12792;
      case 6624:
        return 7413;
      case 6619:
        return 7443;
      case 6649:
        return 7469;
      case 6646:
        return 7462;
      case 3836:
        return 6237;
      case 2783:
        return 2732;
      case 8133:
        return 10058;
      case 10141:
        return 13601;
      case 8349:
        return 10923;
      case 9947:
        return 13771;
      case 6260:
        return 7061;
      case 6261:
      case 6263:
      case 6265:
        return 6155;
      case 6222:
        return 6974;
      case 6223:
      case 6225:
      case 6227:
        return 6952;
      case 6203:
        return 6944;
      case 6204:
      case 6206:
      case 6208:
        return 65;
      case 6247:
        return 6966;
      case 6248:
        return 6375;
      case 6250:
        return 7017;
      case 6252:
        return 4311;
      case 6229:
      case 6230:
      case 6231:
      case 6232:
      case 6233:
      case 6234:
      case 6235:
      case 6236:
      case 6237:
      case 6238:
      case 6239:
      case 6240:
      case 6241:
      case 6242:
      case 6243:
      case 6244:
      case 6245:
      case 6246:
        return 6952;
      case 6267:
        return 360;
      case 6268:
        return 2933;
      case 6269:
      case 6270:
        return 4651;
      case 6271:
      case 6272:
      case 6273:
      case 6274:
        return 4322;
      case 6275:
        return 165;
      case 6276:
      case 6277:
      case 6278:
        return 4322;
      case 6279:
      case 6280:
        return 6183;
      case 6281:
        return 6136;
      case 6282:
        return 6189;
      case 6283:
        return 6183;
      case 6210:
        return 6578;
      case 6211:
        return 170;
      case 6212:
      case 6213:
        return 6538;
      case 6215:
        return 1550;
      case 6216:
      case 6217:
        return 1581;
      case 6218:
        return 4301;
      case 6258:
        return 2561;
      case 10775:
        return 13154;
      case 113:
        return 129;
      case 114:
        return 360;
      case 3058:
        return 2937;
      case 3061:
        return 2961;
      case 3063:
        return 2937;
      case 3065:
        return 2720;
      case 3066:
        return 2926;
      case 1265:
        return 1313;
      case 118:
        return 100;
      case 2263:
        return 2181;
      case 82:
      case 84:
      case 752:
      case 3064:
      case 83: // lesser
        return 65;
      case 3347:
      case 3346:
        return 3325;
      case 1192:
        return 1244;
      case 3062:
        return 2953;
      case 3060:
        return 2964;
      case 2892: // Spinolyp
      case 2894: // Spinolyp
      case 2896: // Spinolyp
        return 2869;
      case 1624:
        return 1555;
      case 3200:
        return 3148;
      case 1354:
      case 1341:
      case 2455:// dagannoth
      case 2454:
      case 2456:
        return 1340;
      case 127:
        return 186;
      case 119:
        return 100;
      case 2881: // supreme
      case 2882: // prime
      case 2883: // rex
        return 2852;
      case 3452:// penance queen
        return 5413;
      case 2745:
        return 2653;
      case 2743:
        return 2645;
      case 1590:// metal dragon
      case 1591:
      case 1592:
        return 89;
      case 2598:
      case 2599:
      case 2600:
      case 2610:
      case 2601:
      case 2602:
      case 2603:
      case 2606:// tzhaar-xil
      case 2591:
      case 2604:// tzhar-hur
        return 2606;
      case 66:
      case 67:
      case 168:
      case 169:
      case 162:
      case 68:// gnomes
        return 193;
      case 160:
      case 161:
        return 194;
      case 163:
      case 164:
        return 193;
      case 438:
      case 439:
      case 440:
      case 441:
      case 442: // Tree spirit
      case 443:
        return 95;
      case 391:
      case 392:
      case 393:
      case 394:
      case 395:// river troll
      case 396:
        return 285;
      case 413:
      case 414:
      case 415:
      case 416:
      case 417:// rock golem
      case 418:
        return 154;

      case 1153:
      case 1154:
      case 1155:
      case 1156:
      case 1157:
      case 1158: // kalphite
        return 1186;
      case 1160: // kalphite
        return 1179;
      case 2734:
      case 2627:// tzhaar
        return 2622;
      case 2630:
      case 2629:
      case 2736:
      case 2738:
        return 2626;
      case 2631:
      case 2632:
        return 2629;
      case 2741:
        return 2635;

      case 908:
        return 129;
      case 909:
        return 147;
      case 911:
        return 65;

      case 1459:// monkey guard
        return 1403;

      case 1633: // pyrefiend
      case 3406:
        return 1581;

      case 1612:// banshee
        return 1525;

      case 1648:
      case 1649:
      case 1650:
      case 1651:
      case 1652:
      case 1653:
      case 1654:
      case 1655:
      case 1656:
      case 1657:// crawling hand
        return 1591;

      case 1604:
      case 1605:
      case 1606:
      case 1607:// aberrant specter
        return 1509;

      case 1618:
      case 1619:// bloodveld
        return 1550;

      case 1643:
      case 1644:
      case 1645:
      case 1646:
      case 1647:// infernal mage
        return 430;

      case 1613:// nechryael
        return 1529;

      case 1610:
      case 1611:// gargoyle
        return 1519;

      case 1615:// abyssal demon
        return 1537;

      case 1770:
      case 1771:
      case 1772:
      case 1773:
      case 2678:
      case 2679:
      case 1774:
      case 1775:
      case 1776:// goblins
        return 312;

      case 132: // monkey
        return 221;

      case 1030:
      case 1031:
      case 1032:
      case 1033:
      case 1034:
      case 1035: // wolfman
        return 6538;

      case 1456:// monkey archer
        return 1395;

      case 108:// scorpion
      case 1477:
        return 247;
      case 107:
      case 144:
        return 6255;

      case 1125:// dad
        return 285;

      case 1096:
      case 1097:
      case 1098:
      case 1942:
      case 1101:// troll
      case 1106:
        return 285;
      case 1095:
        return 285;

      case 123:
      case 122:// hobgoblin
        return 165;

      case 49:// hellhound
      case 142:
      case 95:
        return 6578;

      case 1593:
      case 152:
      case 45:
      case 1558: // wolf
      case 1954:
        return 76;

      case 89:
        return 6375;
      case 133: // unicorns
        return 290;

      case 105:// bear
        return 4921;

      case 74:
      case 75:
      case 76:
        return 5574;

      case 73:
      case 751: // zombie
      case 77:
        return 300;

      case 60:
      case 64:
      case 59:
      case 61:
      case 63:
      case 134:
      case 2035: // spider
      case 62:
      case 1009:
        return 147;

      case 103:
      case 749:
      case 104:
      case 655:
      case 491: // ghost
        return 124;

      case 1585:
      case 110: // giant
        return 4671;
      case 111:
        return 4671;
      case 117:
      case 116:
      case 112:
        return 4651;

      case 50: // kbd
        return 89;

      case 941:// green dragon
      case 55:
      case 742:
      case 1589:
      case 53:
      case 52:
      case 54:
        return 89;
      case 2889:
        return 2860;
      case 81: // cow
      case 397:
        return 5850;

      case 708: // imp
        return 170;

      case 86:
      case 87:
        return 139;
      case 47:// rat
        return 2706;
      case 2457:
        return 2366;
      case 128: // snake
      case 1479:
        return 276;

      case 1017:
      case 2693:
      case 41: // chicken
        return 55;

      case 90:
      case 91:
      case 92:
      case 93: // skeleton
        return 261;
      case 1:
        return 424;
      default:
        return -1;
    }
  }

}
