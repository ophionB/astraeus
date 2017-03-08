package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;

/**
 * The {@link IncomingPacket} responsible logging out a player after a certain amount of time.
 * 
 * @author SeVen
 */
@IncomingPacketOpcode(IncomingPacket.IDLE_LOGOUT)
public final class IdleLogoutPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }
}
