package io.battlerune.game.model.entity.mob.player.update.mask;

import io.battlerune.game.model.entity.mob.player.ChatMessage;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.update.PlayerUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;

/**
 * The {@link PlayerUpdateBlock} implementation that updates a players chat text.
 * 
 * @author SeVen
 */
public class PlayerChatUpdateBlock extends PlayerUpdateBlock {

  /**
   * Creates a new {@link PlayerChatUpdateBlock}.
   */
  public PlayerChatUpdateBlock() {
    super(0x80, UpdateFlag.CHAT);
  }

  @Override
  public void encode(Player entity, GamePacketBuilder builder) {
    final ChatMessage msg = entity.getChatMessage();
    final byte[] bytes = msg.getText();

    builder.writeShort(((msg.getColor() & 0xFF) << 8) + (msg.getEffect() & 0xFF), ByteOrder.LITTLE)
        .write(entity.getRights().getProtocolValue()).write(bytes.length, ByteModification.NEGATION)
        .writeBytesReverse(bytes);
  }

}
