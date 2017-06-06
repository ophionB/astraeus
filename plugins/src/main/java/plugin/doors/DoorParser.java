package plugin.doors;

import com.astraeus.game.world.Direction;
import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.object.GameObjectType;
import com.astraeus.util.GsonParser;
import com.google.gson.JsonObject;

public final class DoorParser extends GsonParser {

    public DoorParser() {
		super("./data/object/doors");
	}

	@Override
	public void parse(JsonObject data) {
		int id = data.get("id").getAsInt();
		GameObjectType type = GameObjectType.valueOf(data.get("type").getAsString());
		Position position = builder.fromJson(data.get("position"), Position.class);		
		boolean open = data.get("open").getAsBoolean();
		Direction orientation = Direction.valueOf(data.get("orientation").getAsString());

		Doors.getDoors().add(new Door(id, type, position, open, orientation));
	}

}