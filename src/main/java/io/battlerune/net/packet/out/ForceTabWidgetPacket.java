package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

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
