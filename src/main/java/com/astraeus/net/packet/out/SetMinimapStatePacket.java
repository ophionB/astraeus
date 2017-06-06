package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that changes the state of the minimap.
 * 
 * The state of the minimap.
 * <p>
 * Normal: {@code 0}
 * <p>
 * 
 * Normal, but unclickable: {@code 1}
 * <p>
 * 
 * Hidden (Black): {@code 2}
 * <p>
 * 
 * @author SeVen
 */
public final class SetMinimapStatePacket implements Sendable {

  private final int state;

  public SetMinimapStatePacket(int state) {
    this.state = state;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(99);
    builder.write(state);
    return builder.toOutgoingPacket();
  }

}
