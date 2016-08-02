package plugin.dialog;

import astraeus.game.model.entity.mob.player.Player;
import astraeus.game.model.widget.dialog.Dialogue;
import astraeus.game.model.widget.dialog.DialogueFactory;
import astraeus.game.model.widget.dialog.Expression;

public final class AppearanceDialogue extends Dialogue {

	@Override
	public void sendDialogues(DialogueFactory factory) {
		factory.sendNpcChat(Expression.HAPPY, "Would you care to change your appearance?")
				.sendOption("Change your appearance.", () -> {
					factory.sendPlayerChat("I would like to change my appearance.").onAction(() -> {
						factory.getPlayer().attr().put(Player.CHANGING_APPEARANCE_KEY, true);
						factory.getPlayer().getWidgets().openChatBoxWidget(3559);
					});
				}, "Keep your current appearance.", () -> {
					factory.sendPlayerChat("I would like to keep my current appearance.");
				}).execute();
	}

}
