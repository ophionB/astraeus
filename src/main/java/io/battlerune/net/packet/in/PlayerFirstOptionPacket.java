package io.battlerune.net.packet.in;

import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.PLAYER_OPTION_1)
public final class PlayerFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int otherPlayerIndex = reader.readShort(ByteOrder.LITTLE);

    if (World.getPlayers().get(otherPlayerIndex) == null) {
      return;
    }
  }

}
