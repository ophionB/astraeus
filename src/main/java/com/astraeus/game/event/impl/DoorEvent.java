package com.astraeus.game.event.impl;

import com.astraeus.game.event.Event;
import com.astraeus.game.world.entity.object.GameObject;

public final class DoorEvent implements Event {

  private GameObject door;

  public DoorEvent(GameObject door) {
    this.door = door;
  }

  public GameObject getDoor() {
    return door;
  }

}
