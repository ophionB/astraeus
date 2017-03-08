package plugin.buttons;

import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.ButtonActionEvent;
import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.sound.Volume;
import astraeus.net.packet.out.SetWidgetConfigPacket;

@SubscribesTo(ButtonActionEvent.class)
public final class SoundEffectVolumeButton extends ButtonClick {

	@Override
	protected void execute(Player player, ButtonActionEvent event) {
		switch (event.getButton()) {
		
		case 941:
            player.attr().put(Player.SOUND_EFFECT_VOLUME_KEY, Volume.SILENT);
            player.queuePacket(new SetWidgetConfigPacket(169, player.attr().get(Player.SOUND_EFFECT_VOLUME_KEY).getCode()));
			break;
			
		case 942:
            player.attr().put(Player.SOUND_EFFECT_VOLUME_KEY, Volume.QUIET);
            player.queuePacket(new SetWidgetConfigPacket(169, player.attr().get(Player.SOUND_EFFECT_VOLUME_KEY).getCode()));
			break;
			
		case 943:
            player.attr().put(Player.SOUND_EFFECT_VOLUME_KEY, Volume.NORMAL);
            player.queuePacket(new SetWidgetConfigPacket(169, player.attr().get(Player.SOUND_EFFECT_VOLUME_KEY).getCode()));
			break;
			
		case 944:
            player.attr().put(Player.SOUND_EFFECT_VOLUME_KEY, Volume.HIGH);
            player.queuePacket(new SetWidgetConfigPacket(169, player.attr().get(Player.SOUND_EFFECT_VOLUME_KEY).getCode()));
			break;
			
		case 945:
            player.attr().put(Player.SOUND_EFFECT_VOLUME_KEY, Volume.LOUD);
            player.queuePacket(new SetWidgetConfigPacket(169, player.attr().get(Player.SOUND_EFFECT_VOLUME_KEY).getCode()));
			break;
			
		}
		
	}

	@Override
	public boolean test(ButtonActionEvent event) {
		switch (event.getButton()) {		
		case 941:
		case 942:
		case 943:
		case 944:
		case 945:
			return true;
		
		}
		return false;
	}

}
