package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.TRADE_ANSWER)
public final class TradeAnswerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }

}
