package com.astraeus.net.packet.in;

import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;
import com.astraeus.net.packet.IncomingPacket.IncomingPacketOpcode;

/**
 * The {@link IncomingPacket} responsible for dialogues.
 * 
 * @author SeVen
 */
@IncomingPacketOpcode(40)
public final class DialoguePacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {

    player.getDialogueFactory().execute();

  }
}
