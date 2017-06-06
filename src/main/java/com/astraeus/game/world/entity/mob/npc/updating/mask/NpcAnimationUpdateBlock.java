package com.astraeus.game.world.entity.mob.npc.updating.mask;

import com.astraeus.game.world.entity.mob.Animation;
import com.astraeus.game.world.entity.mob.npc.Npc;
import com.astraeus.game.world.entity.mob.npc.updating.NpcUpdateBlock;
import com.astraeus.game.world.entity.mob.update.UpdateFlag;
import com.astraeus.net.codec.ByteOrder;
import com.astraeus.net.codec.game.GamePacketBuilder;

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
