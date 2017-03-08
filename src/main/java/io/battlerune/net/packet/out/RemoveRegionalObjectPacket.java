package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.Direction;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.object.GameObject;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} implementation that removes an object from a users client.
 *
 * @author Seven
 */
public final class RemoveRegionalObjectPacket implements Sendable {

  /**
   * The {@code object} that is being removed.
   */
  private final GameObject object;

  private final boolean normal;

  /**
   * Creates a new {@link RemoveRegionalObjectPacket} packet.
   *
   * @param object The object to remove.
   */
  public RemoveRegionalObjectPacket(GameObject object, boolean normal) {
    this.object = object;
    this.normal = normal;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    player.queuePacket(new SetUpdateRegionPacket(object.getPosition()));
    GamePacketBuilder builder = new GamePacketBuilder(101);
    builder.write(
        object.getType() << 2 | (normal ? object.getOrientation()
            : Direction.getDoorOrientation(object.getEnumeratedOrientation()) & 3),
        ByteModification.NEGATION).write(0);
    return builder.toOutgoingPacket();
  }

}
