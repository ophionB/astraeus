package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.Sendable;

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
