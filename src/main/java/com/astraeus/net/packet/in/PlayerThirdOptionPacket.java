package com.astraeus.net.packet.in;

import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.PLAYER_OPTION_3)
public final class PlayerThirdOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int otherPlayerIndex = reader.readShort(ByteOrder.LITTLE);

    if (World.getPlayers().get(otherPlayerIndex) == null) {
      return;
    }

    @SuppressWarnings("unused")
    final Player leader = World.getPlayers().get(otherPlayerIndex);
  }

}
