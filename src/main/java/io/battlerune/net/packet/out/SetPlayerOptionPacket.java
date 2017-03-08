package io.battlerune.net.packet.out;

import java.util.Optional;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerOption;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.game.GamePacketBuilder;
import io.battlerune.net.packet.OutgoingPacket;
import io.battlerune.net.packet.PacketHeader;
import io.battlerune.net.packet.Sendable;

/**
 * Shows a context menu while right clicking another player.
 *
 * @author Seven
 */
public final class SetPlayerOptionPacket implements Sendable {

  /**
   * The option to display.
   */
  private PlayerOption option;

  /**
   * If this option should be shown on top.
   */
  private boolean top;

  /**
   * The flag to remove this option.
   */
  private boolean disable;

  /**
   * Creates a new {@link PlayerOption}.
   *
   * @param option The option to show.
   */
  public SetPlayerOptionPacket(PlayerOption option) {
    this(option, false, false);
  }

  /**
   * Creates a new {@link PlayerOption}.
   *
   * @param option The option to show.
   *
   * @param disable The flag to remove the context menu.
   */
  public SetPlayerOptionPacket(PlayerOption option, boolean disable) {
    this(option, false, disable);
  }

  /**
   * Creates a new {@link PlayerOption}.
   *
   * @param option The option to show.
   *
   * @param top The flag to display this as the first option.
   *
   * @param disable The flag to remove this option.
   */
  public SetPlayerOptionPacket(PlayerOption option, boolean top, boolean disable) {
    this.option = option;
    this.top = top;
    this.disable = disable;
  }

  @Override
  public Optional<OutgoingPacket> writePacket(Player player) {
    GamePacketBuilder builder = new GamePacketBuilder(104, PacketHeader.VARIABLE_BYTE);

    builder.write(option.getSlot(), ByteModification.NEGATION)
        .write(top ? 1 : 0, ByteModification.ADDITION)
        .writeString(disable ? "null" : option.getName());
    return builder.toOutgoingPacket();
  }

}
