package plugin.event;

import java.util.logging.Logger;

import io.battlerune.game.event.EventContext;
import io.battlerune.game.event.EventSubscriber;
import io.battlerune.game.event.SubscribesTo;
import io.battlerune.game.model.World;
import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.game.model.entity.mob.player.attr.AttributeKey;
import io.battlerune.game.model.entity.mob.player.event.PostLoginEvent;
import io.battlerune.game.model.entity.mob.player.event.RegisterPlayerEvent;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.util.LoggerUtils;

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
