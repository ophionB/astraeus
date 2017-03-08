package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.object.GameObject;

public final class DoorEvent implements Event {

  private GameObject door;

  public DoorEvent(GameObject door) {
    this.door = door;
  }

  public GameObject getDoor() {
    return door;
  }

}
