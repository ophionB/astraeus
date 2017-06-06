package plugin.event;

import java.util.logging.Logger;

import com.astraeus.game.event.EventContext;
import com.astraeus.game.event.EventSubscriber;
import com.astraeus.game.event.SubscribesTo;
import com.astraeus.game.world.World;
import com.astraeus.game.world.entity.mob.player.Player;
import com.astraeus.game.world.entity.mob.player.attr.AttributeKey;
import com.astraeus.game.world.entity.mob.player.event.PostLoginEvent;
import com.astraeus.game.world.entity.mob.player.event.RegisterPlayerEvent;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.util.LoggerUtils;

@SubscribesTo(RegisterPlayerEvent.class)
public final class RegisterPlayerEventConsumer implements EventSubscriber<RegisterPlayerEvent> {

  private static final Logger logger = LoggerUtils.getLogger(RegisterPlayerEventConsumer.class);

  @Override
  public void subscribe(EventContext context, Player player, RegisterPlayerEvent event) {
    World.register(event.getPlayer());
    event.getPlayer().setRegionChange(true);
    event.getPlayer().getUpdateFlags().add(UpdateFlag.APPEARANCE);
    event.getPlayer()
        .setPosition(event.getPlayer().attr().contains(AttributeKey.valueOf("new_player", true))
            ? Player.DEFAULT_RESPAWN : event.getPlayer().getPosition());
    logger.info(String.format("[REGISTERED]: [user= %s]", event.getPlayer().getUsername()));

    player.post(new PostLoginEvent(event.getPlayer()));
  }

}
