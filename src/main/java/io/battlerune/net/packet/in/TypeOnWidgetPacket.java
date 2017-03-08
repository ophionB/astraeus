package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode({IncomingPacket.TYPE_ON_WIDGET})
public final class TypeOnWidgetPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }

}
