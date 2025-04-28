package noppes.npcs.api.handler.data;

import noppes.npcs.scripted.ScriptedActionManager;

import java.util.function.Consumer;

/**
 * Represents a single “task” that can be executed over multiple ticks,
 * supports delayed start, limited duration, repeating intervals, data storage,
 * and chaining to neighboring tasks.
 */
public interface IAction {

    /**
     * @param task code to execute each time the action fires
     * @return
     */
    IAction setTask(Consumer<IAction> task);

    /**
     *
     * @return action manager the action is scheduled on
     */
    ScriptedActionManager getManager();

    /**
     * @return how many times this action’s {@code action.accept(this)} callback has run (or how many times task ran)
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

    IAction setMaxDuration(int x);

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
    IAction addData(String key, Object value);

    IAction removeData(String key);

    /**
     * @return how many ticks between each invocation of the action callback
     */
    int getUpdateEveryXTick();

    /**
     * Set how many ticks between each invocation of the action callback.
     *
     * @param X tick interval (e.g. 1 = every tick, 20 = once per second)
     */
    IAction setUpdateEveryXTick(int X);

    /**
     * @return how many ticks remain before the action begins (initial delay)
     */
    int getStartAfterTicks();

    /**
     * @param ticks pauses action for this number of ticks (any subsequent action is paused too)
     * @return
     */
    IAction pauseFor(int ticks);

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
    IAction after(IAction after);

    IAction after(String name, int maxDuration, int delay, Consumer<IAction> t);

    IAction after(String name, int delay, Consumer<IAction> t);

    IAction after(int delay, Consumer<IAction> t);

    IAction after(String name, Consumer<IAction> t);

    IAction after(Consumer<IAction> t);

    /**
     * Enqueue another action immediately before this one (pausing this one until done).
     *
     * @param before the action to run prior
     */
    IAction before(IAction before);

    IAction before(String name, int maxDuration, int delay, Consumer<IAction> t);

    IAction before(String name, int delay, Consumer<IAction> t);

    IAction before(int delay, Consumer<IAction> t);

    IAction before(String name, Consumer<IAction> t);

    IAction before(Consumer<IAction> t);
}
