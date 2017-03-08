package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that changes the settings/toggle on a client. This packet is very
 * similar to {@link SetWidgetConfigPacket} however supports integer values.
 * 
 * @author SeVen
 */
public final class SetToggleOnWidgetPacket implements Sendable {

  /**
   * The configuration id.
   */
  private final int id;

  /**
   * The value to change.
   */
  private final int value;

  /**
   * Creates a new {@link SetToggleOnWidgetPacket).
   * 
   * @param id The configuration id.
   * 
   * @param value The value to change.
   */
  public SetToggleOnWidgetPacket(int id, int value) {
    this.id = id;
    this.value = value;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(87);
    builder.writeShort(id, ByteOrder.LITTLE).writeInt(value, ByteOrder.MIDDLE);
    return builder.toOutgoingPacket();
  }

}
