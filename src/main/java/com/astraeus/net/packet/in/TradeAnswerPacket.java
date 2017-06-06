package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.TRADE_ANSWER)
public final class TradeAnswerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }

}
