package io.battlerune.net.packet.in;

import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.out.ServerMessagePacket;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.MAGIC_ON_PLAYER)
public final class MagicOnPlayerPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int otherPlayerIndex = reader.readShort(ByteModification.ADDITION);
    Player other = World.getPlayers().get(otherPlayerIndex);
    @SuppressWarnings("unused")
    final int spell = reader.readShort(ByteOrder.LITTLE);

    if (other == null) {
      player
          .queuePacket(new ServerMessagePacket("You tried to attack a player that doesn't exist."));
      return;
    }
  }

}
