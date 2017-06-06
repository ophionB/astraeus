package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

/**
 * The {@link OutgoingPacket} that displays an npc model on an interface.
 *
 * @author Seven
 */
public final class DisplayNpcHeadModelOnWidgetPacket implements Sendable {

  /**
   * The id of the npc to display.
   */
  private final int npcId;

  /**
   * The id of the interface to display on.
   */
  private final int interfaceId;

  /**
   * Creates a new {@link DisplayNpcHeadModelOnWidgetPacket}.
   *
   * @param npcId The id of the npc to show.
   *
   * @param interfaceId The id of the interface to display on.
   */
  public DisplayNpcHeadModelOnWidgetPacket(int npcId, int interfaceId) {
    this.npcId = npcId;
    this.interfaceId = interfaceId;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(75);
    builder.writeShort(npcId, ByteModification.ADDITION, ByteOrder.LITTLE).writeShort(interfaceId,
        ByteModification.ADDITION, ByteOrder.LITTLE);
    return builder.toOutgoingPacket();
  }

}
