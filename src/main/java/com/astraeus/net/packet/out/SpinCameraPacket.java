package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

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
