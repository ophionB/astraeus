package astraeus.game.task.impl;

import astraeus.game.task.Task;

/**
 * The {@link Task} that will only execute one time.
 * 
 * @author Vult-R
 */
public abstract class RunOnceTask extends Task {

	/**
	 * Creates a new {@link RunOnceTask}.
	 * 
	 * @param immediate
	 * 		The flag that indicates this task will be executed right away.
	 */
	public RunOnceTask(String identifier, boolean immediate) {
		super(identifier, immediate);
	}
	
	/**
	 * Creates a new {@link RunOnceTask}.
	 * 
	 * @param identifier
	 * 		The identifier of this task.
	 * 
	 * @param delay
	 * 		The delay in game ticks this task will sleep for
	 */
	public RunOnceTask(String identifier, int delay) {
		super(identifier, delay, true);
	}
	
	/**
	 * Creates a new {@link RunOnceTask}.
	 * 
	 * @param identifier
	 * 		The identifier of this task.
	 * 
	 * @param delay
	 * 		The delay in game ticks this task will sleep for
	 * 
	 * @param immediate
	 * 		The flag that indicates this task will be executed right away.
	 */
	public RunOnceTask(String identifier, int delay, boolean immediate) {
		super(identifier, delay, immediate);
	}
	
	/**
	 * Creates a new {@link RunOnceTask}.
	 * 
	 * @param identifier
	 * 		The identifier of this task.
	 * 
	 * @param delay
	 * 		The delay in game ticks this task will sleep for
	 * 
	 * @param immediate
	 * 		The flag that indicates this task will be executed right away.
	 * 
	 * @param stackType
	 * 		The type that indicates how this task will stack.
	 */
	public RunOnceTask(String identifier, int delay, boolean immediate, StackType stackType) {
		super(identifier, delay, immediate, stackType);
	}

	@Override
	public void execute() {
		stop();
	}
	
	@Override
	public abstract void onStop();

}
