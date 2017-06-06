package com.astraeus.net.packet.out;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.codec.game.GamePacketBuilder;
import com.astraeus.net.packet.OutgoingPacket;
import com.astraeus.net.packet.Sendable;

public final class SetPrivacyOptionPacket implements Sendable {

  private final int publicChat;

  private final int privateChat;

  private final int tradeChat;

  public SetPrivacyOptionPacket(int publicChat, int privateChat, int tradeChat) {
    this.publicChat = publicChat;
    this.privateChat = privateChat;
    this.tradeChat = tradeChat;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(206);

    builder.write(publicChat).write(privateChat).write(tradeChat);

    return builder.toOutgoingPacket();
  }

}
