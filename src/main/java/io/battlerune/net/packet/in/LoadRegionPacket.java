package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.attr.AttributeKey;
import io.battlerune.game.model.entity.object.GameObjects;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

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
