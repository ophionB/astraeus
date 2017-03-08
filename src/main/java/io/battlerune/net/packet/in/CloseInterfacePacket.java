package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;
import io.battlerune.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for closing interfaces.
 * 
 * @author SeVen
 */
@IncomingPacketOpcode(IncomingPacket.CLOSE_WINDOW)
public class CloseInterfacePacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    if (player.attr().get(Player.BANKING_KEY)) {
      player.attr().put(Player.BANKING_KEY, false);
    }

    if (player.attr().get(Player.SHOPPING_KEY)) {
      player.attr().put(Player.SHOPPING_KEY, false);
    }

    if (player.getRights().equals(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket("[CloseInterface] - Closed Window"));
    }
  }
}
