package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

public final class SpinCameraPacket implements Sendable {

  private final int x;

  private final int y;

  private final int z;

  private final int speed;

  private final int angle;

  public SpinCameraPacket(int x, int y, int z, int speed, int angle) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.speed = speed;
    this.angle = angle;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(177);
    builder.write(x).write(y).writeShort(z).write(speed).write(angle);
    return builder.toOutgoingPacket();
  }

}
