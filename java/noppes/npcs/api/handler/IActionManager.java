package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IAction;
import noppes.npcs.api.handler.data.IActionChain;
import noppes.npcs.api.handler.data.actions.IConditionalAction;

import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Manages a queue of {@link IAction} instances, allowing scheduling of delayed,
 * repeating, or conditional “tasks” for NPC scripting.
 */
public interface IActionManager {

    /**
     * Create a new action instance without immediately scheduling it.
     *
     * @param name            a unique name for this action
     * @param maxDuration     the maximum lifetime of the action in ticks
     * @param startAfterTicks number of ticks to wait before the first run
     * @param action          code to execute each time the action “fires”
     * @return a fresh {@link IAction} object
     */
    IAction create(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    IAction create(String name, int delay, Consumer<IAction> t);

    IAction create(int delay, Consumer<IAction> t);

    IAction create(String name, Consumer<IAction> t);

    IAction create(Consumer<IAction> t);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param predicate supplier checked every tick, if it returns true, task is fired
     * @param task      code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(Supplier<Boolean> predicate, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name      unique name
     * @param predicate supplier checked every tick, if it returns true, task is fired
     * @param task      code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(String name, Supplier<Boolean> predicate, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param predicate     supplier checked every tick, if it returns true, task is fired
     * @param terminateWhen supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @param task          code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name          unique name
     * @param predicate     supplier checked every tick, if it returns true, task is fired
     * @param terminateWhen supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @param task          code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param predicate     supplier checked every tick, if it returns true, task is fired
     * @param terminateWhen supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @param onTermination code to run when the termination predicate returns true
     * @param task          code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> onTermination, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name          unique name
     * @param predicate     supplier checked every tick, if it returns true, task is fired
     * @param terminateWhen supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @param onTermination code to run when the termination predicate returns true
     * @param task          code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> onTermination, Consumer<IAction> task);

    /**
     * Begin processing scheduled actions.  Must be called once.
     */
    void start();

    /**
     * Halt processing of actions.  Queued actions remain but will not run until
     * {@link #start()} is called again.
     */
    void stop();

    /**
     * Schedule an existing action for execution.
     *
     * @param action the action to enqueue
     * @return the action scheduled
     */
    IAction scheduleAction(IAction action);

    /**
     * Convenience for {@link #create(String, int, int, Consumer)} + enqueue.
     *
     * @param name            a unique name for this action
     * @param maxDuration     the maximum lifetime of the action in ticks
     * @param startAfterTicks number of ticks to wait before the first run
     * @param action          code to execute each time the action “fires”
     * @return the action scheduled
     */
    IAction scheduleAction(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Insert an action at a specific position in the queue.
     *
     * @param index  zero-based queue position to insert at
     * @param action the action to insert
     * @return the action scheduled
     */
    IAction scheduleActionAt(int index, IAction action);

    /**
     * Get the zero-based position of an action in the queue.
     *
     * @param action the action to look up
     * @return its index, or -1 if not found
     */
    int getIndex(IAction action);

    /**
     * Peek at the next action to run (the head of the queue).
     *
     * @return the current head action, or null if queue is empty
     */
    IAction getCurrentAction();

    /**
     * Retrieve the entire action queue.
     *
     * @return live reference to the internal {@link Queue} of actions
     */
    Queue<IAction> getActionQueue();


    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name               unique name
     * @param predicate          supplier checked every tick, if it returns true, task is fired
     * @param task               code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction scheduleAction(String name, Supplier<Boolean> predicate, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name               unique name
     * @param predicate          supplier checked every tick, if it returns true, task is fired
     * @param terminateWhen      supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @param task               code to run once predicate first becomes true
     * @return the action scheduled
     */
    IConditionalAction scheduleAction(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> task);

    IConditionalAction scheduleAction(IConditionalAction action);

    /**
     *
     * @return the list of all conditional actions
     */
    List<IConditionalAction> getConditionalActions();

    /**
     * Cancel (remove) the first queued action with the given name.
     *
     * @param name the name assigned when scheduling
     * @return true if one was found and removed, false otherwise
     */
    boolean cancelAction(String name);

    /**
     * Remove every scheduled action immediately.
     */
    void clear();

    /**
     * Convenience: create & enqueue a normal repeating task.
     */
    default void addTask(String name, int maxDuration, int startAfterTicks, Consumer<IAction> task) {
        scheduleAction(name, maxDuration, startAfterTicks, task);
    }

    /**
     * Convenience: create & enqueue a task that will fire exactly once
     * after the given delay, and then auto‐complete.
     *
     * @param name             a unique name for this action
     * @param startAfterTicks  delay before it runs (in ticks)
     * @param task             code to execute once
     */
    default void addSingleTask(String name, int startAfterTicks, Consumer<IAction> task) {
        IAction action = create(name, 1, startAfterTicks, act -> {
            task.accept(act);
            act.markDone();
        });
        // force it to fire on the very next tick once the delay expires
        action.setUpdateEveryXTick(1);
        scheduleAction(action);
    }

    /**
     * Same as above, but fires immediately (no delay).
     */
    default void addSingleTask(String name, Consumer<IAction> task) {
        addSingleTask(name, 0, task);
    }


    /**
     * Convenience: create & enqueue a conditional task that re-checks forever.
     */
    default void addConditionalTask(String name, Supplier<Boolean> predicate, Consumer<IAction> task) {
        scheduleAction(name, predicate, task);
    }

    /**
     * Convenience: create & enqueue a conditional task that gives up after maxChecks.
     */
    default void addConditionalTask(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> task) {
        scheduleAction(name, predicate, terminateWhen, task);
    }


    IAction scheduleParallelAction(IAction action);

    IActionChain chain();

    IActionChain parallelChain();
}
