package com.astraeus.game.event.impl;

import com.astraeus.game.event.Event;
import com.astraeus.game.world.entity.object.GameObject;

public final class ObjectFifthClickEvent implements Event {

  private final GameObject gameObject;

  public ObjectFifthClickEvent(GameObject gameObject) {
    this.gameObject = gameObject;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
