package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.ENTER_REGION)
public final class EnterRegionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

  }

}
