package io.battlerune.game.model.entity.mob.npc.updating.mask;

import io.battlerune.game.model.entity.mob.npc.Npc;
import io.battlerune.game.model.entity.mob.npc.updating.NpcUpdateBlock;
import io.battlerune.game.model.entity.mob.update.UpdateFlag;
import io.battlerune.net.codec.game.GamePacketBuilder;

public class NpcForceChatUpdateBlock extends NpcUpdateBlock {

  public NpcForceChatUpdateBlock() {
    super(0x1, UpdateFlag.FORCED_CHAT);
  }

  @Override
  public void encode(Npc entity, GamePacketBuilder builder) {
    builder.writeString(entity.getForcedChat());
  }

}
