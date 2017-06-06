package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.Direction;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.object.GameObject;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that creates an object for a user in the game world.
 * 
 * @author SeVen
 */
public final class AddObjectPacket implements Sendable {

  /**
   * The object to spawn.
   */
  private final GameObject object;

  /**
   * The flag that denotes this is not a door.
   */
  private final boolean normal;

  /**
   * Creates a new {@link AddObjectPacket}.
   * 
   * @param object The object to spawn.
   *
   * @param normal The flag that denotes this is not a door.
   */
  public AddObjectPacket(GameObject object, boolean normal) {
    this.object = object;
    this.normal = normal;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(151);
    player.queuePacket(new SetUpdateRegionPacket(object.getPosition()));
    builder.write(object.getPosition().getHeight(), ByteModification.ADDITION)
        .writeShort(object.getId(), ByteOrder.LITTLE).write(
            object.getType() << 2 | (normal ? object.getOrientation()
                : Direction.getDoorOrientation(object.getEnumeratedOrientation()) & 3),
            ByteModification.SUBTRACTION);
    return builder.toOutgoingPacket();
  }

}
