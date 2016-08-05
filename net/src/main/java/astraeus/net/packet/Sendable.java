package astraeus.net.packet;

import java.util.Optional;

import astraeus.game.model.entity.mob.player.Player;

/**
 * The functional interface that allows implementing classes the ability to write data to the
 * client.
 * 
 * @author Vult-R
 */
@FunctionalInterface
public interface Sendable {

  Optional<OutgoingPacket> writePacket(Player player);

}
