package plugin.dialog;

import astraeus.game.model.widget.dialog.Dialogue;
import astraeus.game.model.widget.dialog.DialogueFactory;
import astraeus.game.model.widget.dialog.Expression;

public final class DefaultDialogue extends Dialogue {
	
	private final int npcId;
	
	public DefaultDialogue(int npcId) {
		this.npcId = npcId;
	}

	@Override
	public void sendDialogues(DialogueFactory factory) {
        factory.sendNpcChat(npcId, "Hello!", "Welcome to Astraeus!")
        .sendPlayerChat(Expression.HAPPY, "Well hello there stranger!")
        .sendNpcChat(Expression.HAPPY, "Enjoy your stay!", "If you see any bugs, please report them!")
        .execute();
	}

}
