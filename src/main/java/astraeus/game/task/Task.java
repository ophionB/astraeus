package astraeus.game.task;

import java.util.Objects;

/**
 * An abstract model that represents units of work to be carried out in sequence to game ticks.
 * 
 * @author Vult-R
 */
public abstract class Task {

	/**
	 * Represents the enumerated ways a task can stack.
	 */
	public enum StackType {
		
		/**
		 * The type that indicates tasks equal to this one can be executed
		 */
		STACK,
		
		/**
		 * The type that indicates tasks equal to this one will never be executed until the current one is finished.
		 */
		NEVER_STACK
	}
	
	/**
	 * The identifier for this task
	 */
	private final String identifier;
	
	/**
	 * The amount of ticks that have passed.
	 */
	protected int tick = 0;

	/**
	 * The flag that denotes this task has stopped.
	 */
	private boolean stopped = false;
	
	/**
	 * The flag that denotes to interrupt this task.
	 */
	private boolean interrupt;

	/**
	 * The time in ticks to delay this task from starting.
	 */
	private int delay;
	
	/**
	 * The flag that indicates this task is immediate.
	 */
	protected final boolean immediate;

	/**
	 * The type of stack for this task.
	 */
	protected final StackType stackType;
	
	/**
	 * Creates a new {@link Task}.
	 * 
	 * @param delay
	 * 		The delay in game ticks until this task can execute.
	 */
	public Task(String identifier, StackType stackType) {
		this(identifier, 0, true, stackType);
	}

	/**
	 * Creates a new {@link Task}.
	 * 
	 * @param delay
	 * 		The delay in game ticks until this task can execute.
	 */
	public Task(String identifier, int delay, StackType stackType) {
		this(identifier, delay, true, stackType);
	}
	
	/**
	 * Creates a new {@link Task}.
	 * 
	 * @param immediate
	 * 		The flag that denotes to execute this task immediately.
	 */
	public Task(String identifier, boolean immediate, StackType stackType) {
		this(identifier, 0, immediate, stackType);
	}

	/**
	 * Creates a new {@link Task}.
	 * 
	 * @param identifier
	 * 		The identifier for this task.
	 * 
	 * @param delay
	 * 		The delay in game ticks until this task can execute.
	 * 
	 * @param immediate
	 * 		The flag that denotes to execute this task immediately.
	 * 
	 * @param stackType
	 * 		The type for how this task stacks.
	 * 
	 * @param taskType
	 * 		The type for identifying this task.
	 */
	public Task(String identifier, int delay, boolean immediate, StackType stackType) {
		this.identifier = identifier;
		this.delay = delay;
		this.immediate = immediate;
		this.stackType = stackType;
	}
	
	/**
	 * The method called this task executes.
	 */
	public abstract void execute();
	
	/**
	 * The method called when a task stops.
	 */
	public void onStop() {
		
	}
	
	/**
	 * The method called when an exception occurs.
	 */
	public void onException(Exception ex) {
		
	}
	
	/**
	 * Gets the amount of ticks that have passed since this task has been running.
	 */
	public final int getTick() {
		return tick;
	}

	/**
	 * Determines if this task is immediate.
	 */
	public final boolean isImmediate() {
		return immediate;
	}
	
	/**
	 * Gets the type of stack for this task.
	 */
	public final StackType getStackType() {
		return stackType;
	}

	/**
	 * The method that is called when the task starts.
	 */
	public void onStart() {
	}

	/**
	 * The method that is called when the task restarts.
	 */
	public final void reset() {
		tick = 0;
	}

	/**
	 * The method called when the task runs.
	 */
	public final void run() {
		tick++;
		
		if (tick >= delay) {
			if (interrupt) {
				stop();
				return;
			}
			execute();
			reset();
		}
	}

	/**
	 * Gets the amount of ticks this task will sleep for.
	 */
	public final int getDelay() {
		return delay;
	}
	
	/**
	 * Sets the delay for this task.
	 * 
	 * @param ticks
	 * 		The ticks to delay this task for.
	 */
	public final void setDelay(int ticks) {
		if (ticks < 0) {
			throw new IllegalArgumentException("Tick amount must be positive.");
		}

		this.delay = ticks;
	}

	/**
	 * Stops this task.
	 */
	public final void stop() {
		stopped = true;
	}

	/**
	 * Determines if this task has stopped.
	 */
	public final boolean hasStopped() {
		return stopped;
	}

	/**
	 * Determines if this task should be interrupted.
	 */
	public final boolean isInterrupt() {
		return interrupt;
	}

	/**
	 * Sets to interrupt this task it the task doesn't execute.
	 * 
	 * @param interrupt
	 * 		The flag that indicates to interrupt this task.
	 */
	public final void setInterrupt(boolean interrupt) {
		this.interrupt = interrupt;
	}
	
	/**
	 * Gets the identifier for this task.
	 */
	public final String getIdentifier() {
		return identifier;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(identifier);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Task) {
			Task task = (Task) o;
			
			if (task.hashCode() == hashCode()) {
				return true;
			}
			
		}
		return false;
	}
	
}