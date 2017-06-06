package com.astraeus.net.packet.in;

import com.astraeus.game.event.impl.ObjectFifthClickEvent;
import com.astraeus.game.task.impl.DistancedTask;
import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.object.GameObject;
import com.astraeus.net.codec.ByteModification;
import com.astraeus.net.codec.game.ByteBufReader;
import com.astraeus.net.packet.IncomingPacket;
import com.astraeus.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.OBJECT_OPTION_5)
public final class ObjectFifthOptionClickPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int id = reader.readShort(ByteModification.ADDITION);
    int y = reader.readShort(ByteModification.ADDITION);
    int x = reader.readShort();

    // TODO don't create object like this, this is bad
    GameObject object = new GameObject(id, new Position(x, y, player.getPosition().getHeight()));

    if (player == null || object == null || object.getId() != id) {
      return;
    }

    player.startAction(new DistancedTask(player, object.getPosition(), 2) {

      @Override
      public void onReached() {
        player.faceLocation(object.getPosition());
        player.post(new ObjectFifthClickEvent(object));
      }

    });

  }

}
