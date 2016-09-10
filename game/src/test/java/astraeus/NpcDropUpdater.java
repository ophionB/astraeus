package astraeus;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import astraeus.game.model.entity.mob.npc.drop.NpcDrop;
import astraeus.game.model.entity.mob.npc.drop.NpcDrop.Drop;

public final class NpcDropUpdater {

  public static void main(String[] args) throws IOException {    
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    NpcDrop[] drops = new NpcDrop[] {new NpcDrop(9, new Drop[]{
        new Drop(526, NpcDrop.ALWAYS),
        new Drop(1203, NpcDrop.COMMON),
        new Drop(882, 1, 2, NpcDrop.COMMON),
        new Drop(884, 1, 2, NpcDrop.UNCOMMON),
        new Drop(886, 1, 5, NpcDrop.UNCOMMON),
        new Drop(9140, 1, 12, NpcDrop.COMMON),
        new Drop(440, NpcDrop.RARE),
        new Drop(556, 6, 6, NpcDrop.COMMON),
        new Drop(557, 3, 3, NpcDrop.COMMON),
        new Drop(554, 2, 2, NpcDrop.COMMON),
        new Drop(1446, NpcDrop.UNCOMMON),
        new Drop(1448, NpcDrop.RARE),
        new Drop(562, 1, 2, NpcDrop.RARE),
        new Drop(561, NpcDrop.RARE),
        new Drop(565, NpcDrop.RARE),
        new Drop(5318, 4, 4, NpcDrop.COMMON),
        new Drop(5319, 4, 4, NpcDrop.COMMON),
        new Drop(5324, 4, 4, NpcDrop.COMMON),
        new Drop(5322, 3, 3, NpcDrop.COMMON),
        new Drop(5320, 3, 3, NpcDrop.RARE),
        new Drop(5323, 1, 2, NpcDrop.RARE),
        new Drop(5321, 2, 2, NpcDrop.RARE),
        new Drop(995, 1, 30, NpcDrop.COMMON),
        new Drop(1947, NpcDrop.RARE),
        new Drop(2677, NpcDrop.RARE)
    })};
    
    String s = gson.toJson(drops);
    
    try(FileWriter writer = new FileWriter(new File("./npc_drops.json"))) {
      writer.write(s);      
    }
    
  }

}
