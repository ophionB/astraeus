package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.PacketHeader;
import io.battlerune.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that sends a message to a {@link Player}s chatbox.
 * 
 * @author SeVen
 */
public final class ServerMessagePacket implements Sendable {

  /**
   * The message to send.
   */
  private final String message;

  /**
   * Creates a new {@link ServerMessagePacket}.
   */
  public ServerMessagePacket(String message) {
    this.message = message;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(253, PacketHeader.VARIABLE_BYTE);
    builder.writeString(message);
    return builder.toOutgoingPacket();
  }

}
