package io.battlerune.game.model.entity.mob.npc.updating.mask;

import io.battlerune.game.model.Animation;
import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.updating.NpcUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.ByteOrder;
import io.battlerune.net.codec.game.GamePacketBuilder;

public class NpcAnimationUpdateBlock extends NpcUpdateBlock {

  public NpcAnimationUpdateBlock() {
    super(0x10, UpdateFlag.ANIMATION);
  }

  @Override
  public void encode(Npc entity, GamePacketBuilder builder) {
    final Animation animation = entity.getAnimation();
    builder.writeShort(animation.getId(), ByteOrder.LITTLE).write(animation.getDelay());
  }

}
