package com.astraeus.net.packet.in;

import java.util.logging.Logger;

import com.astraeus.game.world.entity.mob.player.ChatMessage;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

/**
 * The {@link IncomingPacket} responsible for chat messages.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.CHAT)
public class ChatMessagePacket implements Receivable {

  public static final Logger logger = Logger.getLogger(ChatMessagePacket.class.getName());

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int effects = reader.readByte(ByteModification.SUBTRACTION);
    final int color = reader.readByte(ByteModification.SUBTRACTION);
    final int size = packet.getSize() - 2;

    final byte[] text = reader.readBytesReverse(size, ByteModification.ADDITION);

    if (effects < 0 || color < 0 || size < 0) {
      return;
    }

    player.setChatMessage(new ChatMessage(color, effects, text));
    player.getUpdateFlags().add(UpdateFlag.CHAT);
  }
}
