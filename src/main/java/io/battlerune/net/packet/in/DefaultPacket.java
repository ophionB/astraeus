package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for various clicking in-game.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode({IncomingPacket.CAMERA_MOVEMENT, IncomingPacket.IDLE_LOGOUT,
    IncomingPacket.FOCUS_CHANGE})
public class DefaultPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }

}
