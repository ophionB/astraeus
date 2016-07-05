package astraeus.net.packet;

import astraeus.game.model.entity.mob.player.Player;

import java.util.Optional;

public interface Sendable {

    Optional<OutgoingPacket> writePacket(Player player);

}
