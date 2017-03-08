package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.CommandEvent;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;

/**
 * The {@link IncomingPacket} responsible for handling user commands send from the client.
 * 
 * @author Vult-R
 */
@IncomingPacketOpcode(IncomingPacket.PLAYER_COMMAND)
public final class CommandPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

    final String input = packet.getReader().getRS2String().trim().toLowerCase();

    player.post(new CommandEvent(input.split(" ")[0], input));

  }

}
