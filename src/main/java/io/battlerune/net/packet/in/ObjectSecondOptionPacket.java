package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ObjectSecondClickEvent;
import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.object.GameObject;
import io.battlerune.game.task.impl.DistancedTask;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.OBJECT_OPTION_2)
public final class ObjectSecondOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int id = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    int y = reader.readShort(ByteOrder.LITTLE);
    int x = reader.readShort(false, ByteModification.ADDITION);

    GameObject object = new GameObject(id, new Position(x, y, player.getPosition().getHeight()));

    if (player == null || object == null || object.getId() != id) {
      return;
    }

    player.startAction(new DistancedTask(player, object.getPosition(), 2) {

      @Override
      public void onReached() {
        player.faceLocation(object.getPosition());
        player.post(new ObjectSecondClickEvent(object));
      }

    });

  }

}
