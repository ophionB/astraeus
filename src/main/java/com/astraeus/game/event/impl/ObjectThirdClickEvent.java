package com.astraeus.game.event.impl;

import com.astraeus.game.event.Event;
import com.astraeus.game.world.entity.object.GameObject;

public final class ObjectThirdClickEvent implements Event {

  private final GameObject gameObject;

  public ObjectThirdClickEvent(GameObject gameObject) {
    this.gameObject = gameObject;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
