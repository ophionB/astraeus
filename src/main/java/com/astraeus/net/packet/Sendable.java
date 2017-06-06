package com.astraeus.net.packet;

import java.util.Optional;

import com.astraeus.game.world.entity.mob.player.Player;

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
