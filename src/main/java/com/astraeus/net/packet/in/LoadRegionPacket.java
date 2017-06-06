package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.attr.AttributeKey;
import com.astraeus.game.world.entity.object.GameObjects;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.LOADED_REGION)
public final class LoadRegionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

    player.attr().put(AttributeKey.valueOf("save", false), true);

    GameObjects.createGlobalObjects(player);
    // TODO this needs to be done better, load ground items for players entering regions
    // GameObjects.createGlobalItems(player);
  }

}
