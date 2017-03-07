package astraeus.net.packet.out;

import java.util.Optional;

import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.codec.ByteOrder;
import astraeus.net.codec.game.GamePacketBuilder;
import astraeus.net.packet.OutgoingPacket;
import astraeus.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that plays a song.
 * 
 * @author SeVen
 */
public final class PlaySongPacket implements Sendable {

  /**
   * The id of the song.
   */
  private final int id;

  /**
   * Creates a new {@link PlaySongPacket}.
   * 
   * @param id The id of the song.
   */
  public PlaySongPacket(int id) {
    this.id = id;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(74);
    if (!player.attr().get(Player.MUSIC_KEY) || id == -1) {
      return Optional.empty();
    }
    builder.writeShort(id, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
