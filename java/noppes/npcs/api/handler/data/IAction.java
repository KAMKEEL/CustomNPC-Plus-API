package noppes.npcs.api.handler.data;

import noppes.npcs.api.handler.IActionManager;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Represents a single "task" that can be executed over multiple ticks,
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
    IActionManager getManager();

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
    IAction setData(String key, Object value);

    IAction removeData(String key);

    boolean hasData(String key);

    /**
     * @return how many ticks between each execution of the action's task
     * Default is 5 ticks (4 times per second)
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
     *              If action was threaded using {@link #threadify()}, sleeps the thread.
     *              Can be forcibly resumed using {@link #resume()}
     * @return
     */
    IAction pauseFor(int ticks);

    IAction pauseFor(long millis);

    /**
     * Must call {@link #threadify()} before using, else throws exception.
     * Pauses IAction's thread until {@link #resume()} is called.
     */
    void pause();

    /**
     * Must call {@link #threadify()} before using, else throws exception.
     * Pauses IAction's thread until the supplied condition is satisfied or {@link #resume()} is called.
     */
    void pauseUntil(Supplier<Boolean> until);

    /**
     * Resumes thread that was previously paused by {@link #pause()},  {@link #pauseUntil(Supplier)}, {@link #pauseFor(int)} or {@link #pauseFor(long)}
     * Must be called from a different thread than the IAction one, as that one is paused, so it won't reach this function if it comes after any of the pausing functions.
     */
    void resume();

    /**
     * @return checks if IAction's getStartAfterTicks > 0, or if IAction's thread is paused if threaded
     * Preferably called from a different thread than the IAction one if it's paused.
     */
    boolean isPaused();

    /**
     * Creates a new thread for task to run into. Allows for pausing and sleeping just this IAction's thread.
     */
    IAction threadify();

    /**
     *
     * @return starts the IActionManager
     */
    IAction start();

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
