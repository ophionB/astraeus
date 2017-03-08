package plugin.shops;

import io.battlerune.game.event.Event;

public final class ShopEvent implements Event {
	
	private final String name;
	
	public ShopEvent(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
