package plugin.click.npc;

import astraeus.game.event.EventContext;
import astraeus.game.event.EventSubscriber;
import astraeus.game.event.SubscribesTo;
import astraeus.game.event.impl.NpcFirstClickEvent;
import astraeus.game.model.entity.mob.player.Player;
import plugin.dialog.AppearanceDialogue;
import plugin.dialog.BankerDialogue;
import plugin.dialog.DefaultDialogue;
import plugin.dialog.GeneralStoreDialogue;

@SubscribesTo(NpcFirstClickEvent.class)
public final class NpcFirstClick implements EventSubscriber<NpcFirstClickEvent> {

	@Override
	public void subscribe(EventContext context, Player player, NpcFirstClickEvent event) {
		switch (event.getNpc().getId()) {
		
		case 494:		
		case 495:
			player.getDialogueFactory().sendDialogue(new BankerDialogue());
			break;
			
		case 599:
			player.getDialogueFactory().sendDialogue(new AppearanceDialogue());
			break;
			
		case 528:
			player.getDialogueFactory().sendDialogue(new GeneralStoreDialogue());
			break;
			
			default:
				player.getDialogueFactory().sendDialogue(new DefaultDialogue(event.getNpc().getId()));
				break;
		
		}
	}

	@Override
	public boolean test(NpcFirstClickEvent event) {
		switch (event.getNpc().getId()) {
		case 494:		
		case 495:
		case 599:			
		case 528:
			return true;
			
		}
		return false;
	}
	
}
