package astraeus.net.packet.in;

import java.util.Optional;

import astraeus.game.model.Position;
import astraeus.game.model.entity.item.Item;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.entity.mob.player.PlayerRights;
import astraeus.game.model.entity.object.GameObjects;
import astraeus.game.task.impl.DistancedTask;
import astraeus.net.codec.ByteOrder;
import astraeus.net.codec.game.ByteBufReader;
import astraeus.net.packet.IncomingPacket;
import astraeus.net.packet.Receivable;
import astraeus.net.packet.out.RemoveGroundItemPacket;
import astraeus.net.packet.out.ServerMessagePacket;

/**
 * The {@link IncomingPacket} responsible for picking up an item on the ground.
 * 
 * @author SeVen
 */
@IncomingPacket.IncomingPacketOpcode(IncomingPacket.PICKUP_GROUND_ITEM)
public final class PickupGroundItemPacket implements Receivable {

  @Override
  public void handlePacket(final Player player, IncomingPacket packet) {
    ByteBufReader reader = packet.getReader();

    final int y = reader.readShort(ByteOrder.LITTLE);
    final int id = reader.readShort(false);
    final int x = reader.readShort(ByteOrder.LITTLE);

    // create the position object
    Position position = new Position(x, y, player.getPosition().getHeight());

    // get the item from the map
    Item[] items = GameObjects.getGroundItems().get(position);

    // validate it exists
    if (items == null) {
      return;
    }
    
    Optional<Item> toPickup = Optional.empty();
    
    for(Item item : items) {
      if (item == null) {
        continue;
      }
      
      if (item.getId() == id) {
        toPickup = Optional.of(item);
      }
    }
    
    toPickup.ifPresent(it -> {      
      
      if (player.getRights().equals(PlayerRights.DEVELOPER) && player.attr().get(Player.DEBUG_KEY)) {
        player.queuePacket(new ServerMessagePacket(String
            .format("[PickupItem] - Item: %s Position: %s", it.toString(), position.toString())));
      }

      player.startAction(new DistancedTask(player, position, 2) {

        @Override
        public void onReached() {
          player.getInventory().add(it);
          player.queuePacket(new RemoveGroundItemPacket(it));
          GameObjects.getGlobalObjects().remove(it);
        }

      });      
      
    });

  }
}
