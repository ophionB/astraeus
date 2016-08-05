package astraeus.net.packet.out;

import java.util.Optional;

import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.codec.game.GamePacketBuilder;
import astraeus.net.packet.OutgoingPacket;
import astraeus.net.packet.Sendable;

public final class SetSpriteColorPacket implements Sendable {

  private final int id;

  private final int color;

  public SetSpriteColorPacket(int id, int color) {
    this.id = id;
    this.color = color;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(203);
    builder.writeInt(id).writeInt(color);
    return builder.toOutgoingPacket();
  }

}
