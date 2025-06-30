package noppes.npcs.api.handler.data;

import noppes.npcs.api.handler.IActionManager;
import noppes.npcs.api.handler.data.actions.IConditionalAction;

import java.util.function.Consumer;
import java.util.function.Function;

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
     * @return True if was scheduled in the queues using any of the schedule methods, false if was only created.
     */
    boolean isScheduled();

    /**
     * @return how many times this action’s task has been executed
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
     * @return the maximum number of ticks this action is allowed to run before auto marking done
     *
     * P.S: If max duration is reached and this IAction's thread (created using {@link #threadify()}) is paused by any of the pausing methods,
     *      the thread is forcibly resumed and finishes the task execution.
     */
    int getMaxDuration();

    /**
     * @param ticks max duration
     *          default: -1,  infinite
     * @return
     */
    IAction setMaxDuration(int ticks);

    /**
     * @return the maximum number of counts this action is allowed to run before auto marking done
     */
    int getMaxCount();

    /**
     * @param n max count, task auto marks done after running for n counts
     *          default: -1, infinite
     * @return
     */
    IAction times(int n);

    /**
     * Execute task only once, mark done
     * equivalent to times(1)
     *
     * @return
     */
    IAction once();

    /**
     * Mark this action as complete and de-schedules it from its queue.
     * Forcibly resumes action if paused or had its thread slept with the IAction pausing methods.
     *
     */
    void markDone();

    /**
     * @return true if {@link #markDone()} was called (or maxDuration reached)
     */
    boolean isDone();

    /**
     * marks done and safely dumps the action's data and thread
     */
    void kill();

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
    int getUpdateEvery();

    /**
     * Set how many ticks between each execution of the action task.
     *
     * @param ticks tick interval (e.g. 1 = every tick, 20 = once per second)
     */
    IAction updateEvery(int ticks);

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
    void pauseUntil(Function<IAction,Boolean> until);

    /**
     * Resumes thread that was previously paused by {@link #pause()},  {@link #pauseUntil(Function)}, {@link #pauseFor(int)} or {@link #pauseFor(long)}
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

    /**
     * Enqueue an IConditionalAction on the conditional chain
     *
     * @param after the scheduled IConditionalAction
     */
    IConditionalAction conditional(IConditionalAction after);

    IConditionalAction conditional(Function<IAction,Boolean> condition, Consumer<IAction> task);

    IConditionalAction conditional(String name, Function<IAction,Boolean> condition, Consumer<IAction> task);

    IConditionalAction conditional(Function<IAction,Boolean> condition, Consumer<IAction> task, Function<IAction,Boolean> terminate);

    IConditionalAction conditional(String name, Function<IAction,Boolean> condition, Consumer<IAction> task, Function<IAction,Boolean> terminate);

    IConditionalAction conditional(Function<IAction,Boolean> condition, Consumer<IAction> task, Function<IAction,Boolean> terminateWhen, Consumer<IAction> onTermination);

    IConditionalAction conditional(String name, Function<IAction,Boolean> condition, Consumer<IAction> task, Function<IAction,Boolean> terminateWhen, Consumer<IAction> onTermination);

    /**
     * Enqueue another IAction on the parallel chain which starts firing simultaneously as this.
     *
     * @param after the scheduled parallel action
     */
    IAction parallel(IAction after);

    IAction parallel(Consumer<IAction> task);

    IAction parallel(int delay, Consumer<IAction> task);

    IAction parallel(String name, Consumer<IAction> task);

    IAction parallel(String name, int startAfterTicks, Consumer<IAction> task);

    IAction parallel(String name, int maxDuration, int delay, Consumer<IAction> t);
}
