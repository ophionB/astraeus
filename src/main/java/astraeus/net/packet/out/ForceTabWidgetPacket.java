package astraeus.net.packet.out;

import java.util.Optional;

import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.update.UpdateFlag;
import astraeus.net.codec.ByteModification;
import astraeus.net.codec.game.GamePacketBuilder;
import astraeus.net.packet.OutgoingPacket;
import astraeus.net.packet.Sendable;

public final class ForceTabWidgetPacket implements Sendable {

  private final int id;

  public ForceTabWidgetPacket(int id) {
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(106);
    builder.write(id, ByteModification.NEGATION);
    player.getUpdateFlags().add(UpdateFlag.APPEARANCE);
    return builder.toOutgoingPacket();
  }

}
