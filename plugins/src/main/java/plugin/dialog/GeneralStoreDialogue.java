package plugin.dialog;

import io.battlerune.game.model.widget.dialog.Dialogue;
import io.battlerune.game.model.widget.dialog.DialogueFactory;
import plugin.shops.ShopEvent;

public final class GeneralStoreDialogue extends Dialogue {

	@Override
	public void sendDialogues(DialogueFactory factory) {
        factory.sendNpcChat("Can I help you at all?")
		.sendOption("Yes please. What are you selling?", () -> {
			factory.onAction(() -> {
				factory.getPlayer().post(new ShopEvent("General Store"));
			});
		}, "No thanks.", () -> {
			factory.sendPlayerChat("No thanks.");
		}).execute();		
	}

}
