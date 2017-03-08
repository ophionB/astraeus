package io.battlerune.game.model.entity.mob.npc.updating.mask;

import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.updating.NpcUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.game.GamePacketBuilder;

public final class NpcGraphicsUpdateBlock extends NpcUpdateBlock {

  public NpcGraphicsUpdateBlock() {
    super(0x80, UpdateFlag.GRAPHICS);
  }

  @Override
  public void encode(Npc entity, GamePacketBuilder builder) {
    builder.writeShort(entity.getGraphic().getId()).writeInt(entity.getGraphic().getHeight());
  }

}
