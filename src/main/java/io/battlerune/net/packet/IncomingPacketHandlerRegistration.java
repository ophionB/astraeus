package io.battlerune.net.packet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import io.battlerune.game.model.entity.mob.player.Player;
import io.battlerune.net.packet.in.AppearanceChangePacket;
import io.battlerune.net.packet.in.AttackNpcPacket;
import io.battlerune.net.packet.in.ButtonClickPacket;
import io.battlerune.net.packet.in.ChatMessagePacket;
import io.battlerune.net.packet.in.CloseInterfacePacket;
import io.battlerune.net.packet.in.CommandPacket;
import io.battlerune.net.packet.in.DefaultPacket;
import io.battlerune.net.packet.in.DialoguePacket;
import io.battlerune.net.packet.in.DropItemPacket;
import io.battlerune.net.packet.in.EnterRegionPacket;
import io.battlerune.net.packet.in.EquipItemPacket;
import io.battlerune.net.packet.in.IdleLogoutPacket;
import io.battlerune.net.packet.in.ItemFirstOptionPacket;
import io.battlerune.net.packet.in.ItemOnGroundItemPacket;
import io.battlerune.net.packet.in.ItemOnItemPacket;
import io.battlerune.net.packet.in.ItemOnNpcPacket;
import io.battlerune.net.packet.in.ItemOnObjectPacket;
import io.battlerune.net.packet.in.ItemOnPlayerPacket;
import io.battlerune.net.packet.in.ItemSecondOptionPacket;
import io.battlerune.net.packet.in.ItemThirdOptionPacket;
import io.battlerune.net.packet.in.LoadRegionPacket;
import io.battlerune.net.packet.in.MagicOnFloorItemPacket;
import io.battlerune.net.packet.in.MagicOnItemPacket;
import io.battlerune.net.packet.in.MagicOnNpcPacket;
import io.battlerune.net.packet.in.MagicOnObjectPacket;
import io.battlerune.net.packet.in.MagicOnPlayerPacket;
import io.battlerune.net.packet.in.MoveItemPacket;
import io.battlerune.net.packet.in.MovementPacket;
import io.battlerune.net.packet.in.NpcFirstClickPacket;
import io.battlerune.net.packet.in.NpcSecondClickPacket;
import io.battlerune.net.packet.in.NpcThirdClickPacket;
import io.battlerune.net.packet.in.ObjectFirstOptionPacket;
import io.battlerune.net.packet.in.ObjectSecondOptionPacket;
import io.battlerune.net.packet.in.ObjectThirdOptionPacket;
import io.battlerune.net.packet.in.PickupGroundItemPacket;
import io.battlerune.net.packet.in.PlayerFifthOptionPacket;
import io.battlerune.net.packet.in.PlayerFirstOptionPacket;
import io.battlerune.net.packet.in.PlayerFourthOptionPacket;
import io.battlerune.net.packet.in.PlayerRelationPacket;
import io.battlerune.net.packet.in.PlayerSecondOptionPacket;
import io.battlerune.net.packet.in.PlayerThirdOptionPacket;
import io.battlerune.net.packet.in.ReportPlayerPacket;
import io.battlerune.net.packet.in.TradeAnswerPacket;
import io.battlerune.net.packet.in.TypeOnWidgetPacket;
import io.battlerune.net.packet.in.WidgetContainerFifthOptionPacket;
import io.battlerune.net.packet.in.WidgetContainerFirstOptionPacket;
import io.battlerune.net.packet.in.WidgetContainerFourthOptionPacket;
import io.battlerune.net.packet.in.WidgetContainerSecondOptionPacket;
import io.battlerune.net.packet.in.WidgetContainerSixthOptionPacket;
import io.battlerune.net.packet.in.WidgetContainerThirdOptionPacket;
import io.battlerune.util.LoggerUtils;

/**
 * Handles registering the handlers responsible for intervening {@link IncomingPacket}s.
 * 
 * @author Seven
 */
public final class IncomingPacketHandlerRegistration {

  /**
   * The single logger for this class.
   */
  private static final Logger logger =
      LoggerUtils.getLogger(IncomingPacketHandlerRegistration.class);

  /**
   * The map of {@IncomingPacket} opcodes mapped to their listener.
   */
  private final static Map<Integer, Receivable> incomingPackets = new HashMap<>();

  /**
   * Intercepts an {@link IncomingPacket} for a {@code player} and dispatches the packet to the
   * correct listener to be handled.
   * 
   * @param player The player that is receiving the packet.
   * 
   * @param packet The incoming packet to intervene.
   */
  public static final void dispatchToHandler(Player player, IncomingPacket packet) {
    Optional<Receivable> listener = Optional.ofNullable(incomingPackets.get(packet.getOpcode()));

    if (player.attr().get(Player.DEBUG_NETWORK_KEY)) {
      logger.info(String.format(packet.toString()));
    }

    listener.ifPresent(msg -> msg.handlePacket(player, packet));
  }

  /**
   * Registers a handler for the {@link IncomingPacket}s.
   * 
   * @param listener The handler to register.
   */
  private static final void registerHandler(Receivable listener) {
    final IncomingPacket.IncomingPacketOpcode annotation =
        listener.getClass().getAnnotation(IncomingPacket.IncomingPacketOpcode.class);
    if (annotation != null) {
      for (final int opcode : annotation.value()) {
        incomingPackets.put(opcode, listener);
      }
    }
  }

  /**
   * Initializes all the {@link IncomingPacket} handlers when this object is created.
   */
  public IncomingPacketHandlerRegistration() {
    registerHandler(new PlayerSecondOptionPacket());
    registerHandler(new MagicOnPlayerPacket());
    registerHandler(new WidgetContainerFirstOptionPacket());
    registerHandler(new WidgetContainerSecondOptionPacket());
    registerHandler(new WidgetContainerThirdOptionPacket());
    registerHandler(new WidgetContainerFourthOptionPacket());
    registerHandler(new WidgetContainerFifthOptionPacket());
    registerHandler(new WidgetContainerSixthOptionPacket());
    registerHandler(new TypeOnWidgetPacket());
    registerHandler(new MagicOnNpcPacket());
    registerHandler(new AttackNpcPacket());
    registerHandler(new PlayerFirstOptionPacket());
    registerHandler(new PlayerSecondOptionPacket());
    registerHandler(new PlayerThirdOptionPacket());
    registerHandler(new PlayerFourthOptionPacket());
    registerHandler(new PlayerFifthOptionPacket());
    registerHandler(new TradeAnswerPacket());
    registerHandler(new AppearanceChangePacket());
    registerHandler(new ButtonClickPacket());
    registerHandler(new ChatMessagePacket());
    registerHandler(new DefaultPacket());
    registerHandler(new ItemFirstOptionPacket());
    registerHandler(new ItemSecondOptionPacket());
    registerHandler(new ItemThirdOptionPacket());
    registerHandler(new ObjectFirstOptionPacket());
    registerHandler(new ObjectSecondOptionPacket());
    registerHandler(new ObjectThirdOptionPacket());
    registerHandler(new CloseInterfacePacket());
    registerHandler(new CommandPacket());
    registerHandler(new DialoguePacket());
    registerHandler(new DropItemPacket());
    registerHandler(new IdleLogoutPacket());
    registerHandler(new MagicOnFloorItemPacket());
    registerHandler(new MagicOnItemPacket());
    registerHandler(new MoveItemPacket());
    registerHandler(new PickupGroundItemPacket());
    registerHandler(new PlayerRelationPacket());
    registerHandler(new EnterRegionPacket());
    registerHandler(new LoadRegionPacket());
    registerHandler(new ReportPlayerPacket());
    registerHandler(new ItemOnItemPacket());
    registerHandler(new ItemOnObjectPacket());
    registerHandler(new ItemOnNpcPacket());
    registerHandler(new ItemOnGroundItemPacket());
    registerHandler(new ItemOnPlayerPacket());
    registerHandler(new MovementPacket());
    registerHandler(new EquipItemPacket());
    registerHandler(new NpcFirstClickPacket());
    registerHandler(new NpcSecondClickPacket());
    registerHandler(new NpcThirdClickPacket());
    registerHandler(new MagicOnObjectPacket());
  }
}
