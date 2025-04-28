package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IAction;
import noppes.npcs.api.handler.data.IActionChain;

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
     * @param action          logic to execute each time the action “fires”
     * @return a fresh {@link IAction} object
     */
    IAction create(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

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
     */
    void scheduleAction(IAction action);

    /**
     * Convenience for {@link #create(String, int, int, Consumer)} + enqueue.
     *
     * @param name            a unique name for this action
     * @param maxDuration     the maximum lifetime of the action in ticks
     * @param startAfterTicks number of ticks to wait before the first run
     * @param action          logic to execute each time the action “fires”
     */
    void scheduleAction(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Insert an action at a specific position in the queue.
     *
     * @param index  zero-based queue position to insert at
     * @param action the action to insert
     */
    void scheduleActionAt(int index, IAction action);

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
     * Schedule a “conditional” action: every {@code checkIntervalTicks}, evaluate
     * the predicate, and as soon as it returns true, fire the action and remove it.
     *
     * @param name               a unique name for this conditional action
     * @param checkIntervalTicks number of ticks between each predicate check
     * @param predicate          no-arg boolean supplier deciding when to fire
     * @param action             logic to execute once when predicate first becomes true
     */
    void scheduleConditionalAction(String name, int checkIntervalTicks, Supplier<Boolean> predicate, Consumer<IAction> action);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name               unique name
     * @param checkIntervalTicks ticks between predicate tests
     * @param predicate          supplier returning true when it should fire
     * @param task               logic to run once when predicate first becomes true
     * @param maxChecks          maximum times to test predicate before auto‐cancelling
     */
    void scheduleConditionalAction(String name, int checkIntervalTicks, Supplier<Boolean> predicate, Consumer<IAction> task, int maxChecks);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name               unique name
     * @param checkIntervalTicks ticks between predicate tests
     * @param predicate          supplier returning true when it should fire
     * @param terminateWhen      supplier returning true when it should terminate (gets marked done)
     * @param task               logic to run once when predicate first becomes true
     * @param maxChecks          maximum times to test predicate before auto‐cancelling
     */
    void scheduleConditionalAction(String name, int checkIntervalTicks, Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> task, int maxChecks);

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
     * @param task             logic to execute once
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
    default void addConditionalTask(String name,
                                    int checkIntervalTicks,
                                    Supplier<Boolean> predicate,
                                    Consumer<IAction> task) {
        scheduleConditionalAction(name, checkIntervalTicks, predicate, task);
    }

    /**
     * Convenience: create & enqueue a conditional task that gives up after maxChecks.
     */
    default void addConditionalTask(String name,
                                    int checkIntervalTicks,
                                    Supplier<Boolean> predicate,
                                    Consumer<IAction> task,
                                    int maxChecks) {
        scheduleConditionalAction(name, checkIntervalTicks, predicate, task, maxChecks);
    }

    IActionChain chain();
}
