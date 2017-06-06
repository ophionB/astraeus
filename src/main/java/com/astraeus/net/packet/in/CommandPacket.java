package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.CommandEvent;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;

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
