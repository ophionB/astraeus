package astraeus.game.task.impl;

import astraeus.game.model.entity.mob.Mob;
import astraeus.game.task.Task;

/**
 * Represents a task that involves a mob.
 * 
 * @author Vult-R
 */
public abstract class MobTask<T extends Mob> extends Task {

	/**
	 * The mob that this task is for.
	 */
	protected final T mob;

	/**
	 * Creates a new {@link MobTask}.
	 * 
	 * @param identifier
	 * 			The identifier for this task.
	 * 
	 * @param mob
	 *            The mob that this task is for.
	 * 
	 * @param immediate
	 *            The flag that denotes this task will execute immediately
	 *            instead of being queued.
	 */
	public MobTask(String identifier, T mob, boolean immediate) {
		super(identifier, 0, immediate, StackType.STACK);
		this.mob = mob;
	}

	/**
	 * Creates a new {@link MobTask}.
	 * 
	 * @param identifier
	 * 			The identifier for this task.
	 * 
	 * @param mob
	 *            The mob that this task is for.
	 * 
	 * @param delay
	 *            The delay in game ticks that this task will sleep for.
	 */
	public MobTask(String identifier, T mob, int delay) {
		super(identifier, delay, false, StackType.STACK);
		this.mob = mob;
	}

	/**
	 * Creates a new {@link MobTask}.
	 * 
	 * @param identifier
	 * 			The identifier for this task.
	 * 
	 * @param mob
	 *            The mob that this task is for.
	 * 
	 * @param delay
	 *            The delay in game ticks that this task will sleep for.
	 * 
	 * @param immediate
	 *            The flag that denotes this task will execute immediately
	 *            instead of being queued.
	 */
	public MobTask(String identifier, T mob, int delay, boolean immediate) {
		super(identifier, delay, immediate, StackType.STACK);
		this.mob = mob;
	}

	/**
	 * Creates a new {@link MobTask}.
	 * 
	 * @param identifier
	 * 			The identifier for this task.
	 * 
	 * @param mob
	 *            The mob that this task is for.
	 * 
	 * @param delay
	 *            The delay in game ticks that this task will sleep for.
	 * 
	 * @param immediate
	 *            The flag that denotes this task will execute immediately
	 *            instead of being queued.
	 * 
	 * @param stackType
	 *            The type of stack for this task.
	 * 
	 * @param taskType
	 *            The type of task being executed.
	 */
	public MobTask(String identifier, T mob, int delay, boolean immediate, StackType stackType) {
		super(identifier, delay, immediate, stackType);
		this.mob = mob;
	}

	/**
	 * Gets the mob.
	 */
	public T getMob() {
		return mob;
	}

}