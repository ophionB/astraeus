package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;

@IncomingPacketOpcode(IncomingPacket.WIDGET_CONTAINER_OPTION_6)
public final class WidgetContainerSixthOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    int amountX = packet.getReader().readInt();

    if (amountX == 0) {
      amountX = 1;
    }
  }

}
