package plugin.shops;

import java.util.Arrays;
import java.util.Objects;

import com.astraeus.game.task.Task;
import com.astraeus.game.world.entity.item.Item;
import com.astraeus.net.packet.out.UpdateItemsOnWidgetPacket;

/**
 * The task that will restock items in shop containers when needed.
 *
 * @author lare96 <http://github.com/lare96>
 */
public final class ShopRestockTask extends Task {

    /**
     * The container that will be restocked.
     */
    private final Shop container;

    /**
     * Creates a new {@link ShopRestockTask}.
     *
     * @param container
     *            the container that will be restocked.
     */
    public ShopRestockTask(Shop container) {
        super(20, false);
        this.container = container;
    }

    @Override
    public void execute() {
        if (container.restockCompleted() || !container.isRestock()) {
            this.stop();
            return;
        }
        
        Arrays.stream(container.getContainer().container()).filter(Objects::nonNull).forEach(this::restock);
    }

    /**
     * Attempts to restock {@code item} for the container.
     *
     * @param item
     *            the item to attempt to restock.
     */
    private void restock(Item item) {
        if (container.getItemCache().containsKey(item.getId()) && item.getAmount() < container.getItemCache().get(item.getId())) {
            item.add(1);            
            container.getPlayers().stream().filter(Objects::nonNull).forEach(
                p -> p.queuePacket(new UpdateItemsOnWidgetPacket(3900, container.getContainer().container())));
        }
    }
    
}
