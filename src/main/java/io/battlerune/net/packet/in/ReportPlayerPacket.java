package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible reporting another player.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.REPORT_PLAYER)
public final class ReportPlayerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }
}
