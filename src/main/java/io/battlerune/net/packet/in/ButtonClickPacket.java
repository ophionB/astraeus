package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ButtonActionEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.PlayerRights;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for clicking buttons on the client.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.BUTTON_CLICK)
public class ButtonClickPacket implements Receivable {

  @Override
  public void handlePacket(final Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int button = reader.readShort();

    if (player.getRights().greaterOrEqual(PlayerRights.DEVELOPER)
        && player.attr().get(Player.DEBUG_KEY)) {
      player.queuePacket(new ServerMessagePacket(String.format("[button= %d]", button)));
    }

    player.post(new ButtonActionEvent(button));
  }

}
