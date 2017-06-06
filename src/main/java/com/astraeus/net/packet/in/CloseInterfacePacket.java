package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.PlayerRights;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;
import com.astraeus.net.packet.out.ServerMessagePacket;

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
