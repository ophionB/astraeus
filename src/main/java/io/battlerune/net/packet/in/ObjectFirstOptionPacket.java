package io.battlerune.net.packet.in;

import io.battlerune.game.event.impl.ObjectFirstClickEvent;
import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.object.GameObject;
import io.battlerune.game.task.impl.DistancedTask;
import io.battlerune.net.codec.ByteModification;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.ByteBufReader;
import io.battlerune.net.packet.IncomingPacket;
import io.battlerune.net.packet.Receivable;

@IncomingPacket.IncomingPacketOpcode(IncomingPacket.OBJECT_OPTION_1)
public final class ObjectFirstOptionPacket implements Receivable {

  @Override
  public void handlePacket(Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    int x = reader.readShort(ByteOrder.LITTLE, ByteModification.ADDITION);
    int id = reader.readShort(false);
    int y = reader.readShort(false, ByteModification.ADDITION);

    GameObject object = new GameObject(id, new Position(x, y));

    if (player == null || object == null) {
      return;
    }

    player.startAction(new DistancedTask(player, object.getPosition(), 2) {

      @Override
      public void onReached() {
        player.faceLocation(object.getPosition());
        player.post(new ObjectFirstClickEvent(object));
      }

    });

  }

}