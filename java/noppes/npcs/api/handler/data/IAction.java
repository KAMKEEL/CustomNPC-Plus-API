package noppes.npcs.api.handler.data;

import java.util.function.Consumer;

/**
 * Represents a single “task” that can be executed over multiple ticks,
 * supports delayed start, limited duration, repeating intervals, data storage,
 * and chaining to neighboring tasks.
 */
public interface IAction {

    /**
     * @return how many times this action’s {@code action.accept(this)} callback has run
     */
    int getCount();

    /**
     * @return how many ticks have elapsed since this action actually began (excluding start delay)
     */
    int getDuration();

    /**
     * @return the name given at creation/scheduling time
     */
    String getName();

    /**
     * @return the maximum number of ticks this action is allowed to run before auto-terminating
     */
    int getMaxDuration();

    /**
     * Mark this action as complete.  Once done, it will be removed on the next tick.
     */
    void markDone();

    /**
     * @return true if {@link #markDone()} was called (or maxDuration reached)
     */
    boolean isDone();

    /**
     * Retrieve arbitrary per-action data.
     *
     * @param key a string key
     * @return the stored value, or null if not set
     */
    Object getData(String key);

    /**
     * Store arbitrary per-action data.
     *
     * @param key   a string key
     * @param value any object to associate with this action
     */
    void addData(String key, Object value);

    /**
     * @return how many ticks between each invocation of the action callback
     */
    int getUpdateEveryXTick();

    /**
     * Set how many ticks between each invocation of the action callback.
     *
     * @param X tick interval (e.g. 1 = every tick, 20 = once per second)
     */
    void setUpdateEveryXTick(int X);

    /**
     * @return how many ticks remain before the action begins (initial delay)
     */
    int getStartAfterTicks();

    /**
     * Factory helper so that from within one action you can create
     * new IAction instances without referencing the manager directly.
     *
     * @param name            a unique name for the new action
     * @param maxDuration     its maximum lifetime
     * @param startAfterTicks initial delay in ticks
     * @param action          callback logic
     * @return a new IAction
     */
    IAction create(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * @return the next action in the queue (or null if none or at end)
     */
    IAction getNext();

    /**
     * @return the previous action in the queue (or null if none or at front)
     */
    IAction getPrevious();

    /**
     * Enqueue another action immediately after this one.
     *
     * @param after the action to run next
     */
    void scheduleAfter(IAction after);

    /**
     * Enqueue another action immediately before this one (pausing this one until done).
     *
     * @param before the action to run prior
     */
    void scheduleBefore(IAction before);

    /**
     * Note: Only for Conditional Actions
     * @return how many times this conditional action has tested its predicate
     */
    int getCheckCount();

    /**
     * Note: Only for Conditional Actions
     * @return the maximum number of checks before auto‐expiring, or –1 if unlimited
     */
    int getMaxChecks();
}
