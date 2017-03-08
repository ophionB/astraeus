package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.object.GameObject;

public final class ObjectFourthClickEvent implements Event {

  private final GameObject gameObject;

  public ObjectFourthClickEvent(GameObject gameObject) {
    this.gameObject = gameObject;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
