package io.battlerune.net.packet.in;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;
import io.battlerune.net.packet.IncomingPacket.IncomingPacketOpcode;

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
