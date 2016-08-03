package astraeus.net.packet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import astraeus.game.model.entity.mob.player.Player;
import astraeus.net.packet.in.AppearanceChangePacket;
import astraeus.net.packet.in.AttackNpcPacket;
import astraeus.net.packet.in.ButtonClickPacket;
import astraeus.net.packet.in.ChatMessagePacket;
import astraeus.net.packet.in.CloseInterfacePacket;
import astraeus.net.packet.in.CommandPacket;
import astraeus.net.packet.in.DefaultPacket;
import astraeus.net.packet.in.DialoguePacket;
import astraeus.net.packet.in.DropItemPacket;
import astraeus.net.packet.in.EnterRegionPacket;
import astraeus.net.packet.in.EquipItemPacket;
import astraeus.net.packet.in.IdleLogoutPacket;
import astraeus.net.packet.in.ItemFirstOptionPacket;
import astraeus.net.packet.in.ItemOnGroundItemPacket;
import astraeus.net.packet.in.ItemOnItemPacket;
import astraeus.net.packet.in.ItemOnNpcPacket;
import astraeus.net.packet.in.ItemOnObjectPacket;
import astraeus.net.packet.in.ItemOnPlayerPacket;
import astraeus.net.packet.in.ItemSecondOptionPacket;
import astraeus.net.packet.in.ItemThirdOptionPacket;
import astraeus.net.packet.in.LoadRegionPacket;
import astraeus.net.packet.in.MagicOnFloorItemPacket;
import astraeus.net.packet.in.MagicOnItemPacket;
import astraeus.net.packet.in.MagicOnNpcPacket;
import astraeus.net.packet.in.MagicOnPlayerPacket;
import astraeus.net.packet.in.MoveItemPacket;
import astraeus.net.packet.in.MovementPacket;
import astraeus.net.packet.in.NpcFirstClickPacket;
import astraeus.net.packet.in.NpcSecondClickPacket;
import astraeus.net.packet.in.NpcThirdClickPacket;
import astraeus.net.packet.in.ObjectFirstOptionPacket;
import astraeus.net.packet.in.ObjectSecondOptionPacket;
import astraeus.net.packet.in.ObjectThirdOptionPacket;
import astraeus.net.packet.in.PickupGroundItemPacket;
import astraeus.net.packet.in.PlayerFifthOptionPacket;
import astraeus.net.packet.in.PlayerFirstOptionPacket;
import astraeus.net.packet.in.PlayerFourthOptionPacket;
import astraeus.net.packet.in.PlayerRelationPacket;
import astraeus.net.packet.in.PlayerSecondOptionPacket;
import astraeus.net.packet.in.PlayerThirdOptionPacket;
import astraeus.net.packet.in.ReportPlayerPacket;
import astraeus.net.packet.in.TradeAnswerPacket;
import astraeus.net.packet.in.TypeOnWidgetPacket;
import astraeus.net.packet.in.WidgetContainerFifthOptionPacket;
import astraeus.net.packet.in.WidgetContainerFirstOptionPacket;
import astraeus.net.packet.in.WidgetContainerFourthOptionPacket;
import astraeus.net.packet.in.WidgetContainerSecondOptionPacket;
import astraeus.net.packet.in.WidgetContainerSixthOptionPacket;
import astraeus.net.packet.in.WidgetContainerThirdOptionPacket;
import astraeus.util.LoggerUtils;

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
  }
}
