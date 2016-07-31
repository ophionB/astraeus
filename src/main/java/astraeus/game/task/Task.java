package astraeus.game.task;

import java.util.Objects;

/**
 * An abstract model that represents units of work to be carried out in sequence to game ticks.
 *
 * @author Vult-R
 */
public abstract class Task {

    /**
     * The default instance this task is locked to if one isn't specified.
     */
    public static final Object DEFAULT_INSTANCE = new Object();

    /**
     * Represents the type of polices on how tasks can stack.
     */
    public enum DuplicatePolicy {

        /**
         * The type that indicates duplicate tasks can be executed.
         */
        ALLOW,

        /**
         * The type that indicates no duplicate tasks can be executed.
         */
        DISALLOW
    }

    private final String identifier;

    /**
     * The instance this task is attatched to.
     */
    private final Object attatchment;

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
    protected final DuplicatePolicy duplicatePolicy;

    /**
     * Creates a new {@link Task}.
     *
     * @param identifier      The identifier for this task.
     * @param attatchment     The instance attached to this task.
     * @param delay           The delay in game ticks until this task can execute.
     * @param immediate       The flag that denotes to execute this task immediately.
     * @param duplicatePolicy The policy for duplicate tasks.
     */
    public Task(String identifier, Object attatchment, int delay, boolean immediate, DuplicatePolicy duplicatePolicy) {
        this.identifier = Objects.requireNonNull(identifier);
        this.attatchment = attatchment == null ? DEFAULT_INSTANCE : attatchment;
        this.delay = delay;
        this.immediate = immediate;
        this.duplicatePolicy = duplicatePolicy;
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
     * Gets the policy for this task.
     */
    public final DuplicatePolicy getDuplicatePolicy() {
        return duplicatePolicy;
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
     * @param ticks The ticks to delay this task for.
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
     * Gets the identifier of this task.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Gets the instance attached to this task.
     */
    public Object getAttatchment() {
        return attatchment;
    }

    /**
     * Sets to interrupt this task it the task doesn't execute.
     *
     * @param interrupt The flag that indicates to interrupt this task.
     */
    public final void setInterrupt(boolean interrupt) {
        this.interrupt = interrupt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, attatchment);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Task) {

            Task task = (Task) o;

            if (task.getIdentifier().equals(identifier) && task.getAttatchment().equals(attatchment)) {
                return true;
            }

        }
        return false;
    }

}