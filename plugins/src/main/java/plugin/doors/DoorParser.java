package plugin.doors;

import com.google.gson.JsonObject;

import io.battlerune.game.model.Direction;
import io.battlerune.game.model.Position;
import io.battlerune.game.model.entity.object.GameObjectType;
import io.battlerune.util.GsonParser;

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