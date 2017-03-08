package io.battlerune.game.event.impl;

import io.battlerune.game.event.Event;
import io.battlerune.game.model.entity.item.Item;
import io.battlerune.game.model.entity.object.GameObject;

public final class ItemOnObjectEvent implements Event {

  private final Item item;

  private final GameObject gameObject;

  public ItemOnObjectEvent(Item item, GameObject gameObject) {
    this.item = item;
    this.gameObject = gameObject;
  }

  public Item getItem() {
    return item;
  }

  public GameObject getGameObject() {
    return gameObject;
  }

}
