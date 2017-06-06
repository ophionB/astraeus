package com.astraeus.game.world.entity;

import java.util.LinkedList;

import com.astraeus.game.task.Task;
import com.astraeus.game.world.Position;
import com.astraeus.game.world.entity.mob.Mob;

/**
 * Represents an entity in the game world.
 * 
 * @author Seven
 */
public abstract class Entity {

  private final LinkedList<Task> tasks = new LinkedList<Task>();

  public abstract int size();

  public abstract EntityType type();

  protected Position position;

  public boolean isMob() {
    return getClass() == Mob.class;
  }

  public Mob getMob() {
    return (Mob) this;
  }

  public int getX() {
    return position.getX();
  }

  public int getY() {
    return position.getY();
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public LinkedList<Task> getTasks() {
    return tasks;
  }

}
