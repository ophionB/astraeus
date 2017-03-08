package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.object.GameObject;

public final class ObjectFifthClickEvent implements Event {

  private final GameObject gameObject;

  public ObjectFifthClickEvent(GameObject gameObject) {
    this.gameObject = gameObject;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
