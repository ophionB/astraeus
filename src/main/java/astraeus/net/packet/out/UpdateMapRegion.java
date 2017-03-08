package astraeus.net.packet.out;

import java.util.Optional;

import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.codec.ByteModification;
import astraeus.net.codec.game.GamePacketBuilder;
import astraeus.net.packet.OutgoingPacket;
import astraeus.net.packet.Sendable;

public final class UpdateMapRegion implements Sendable {

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(73);
    player.setLastPosition(player.getPosition().copy());
    builder.writeShort(player.getPosition().getRegionalX() + 6, ByteModification.ADDITION)
        .writeShort(player.getPosition().getRegionalY() + 6);
    return builder.toOutgoingPacket();
  }

}
