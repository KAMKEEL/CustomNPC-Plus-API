package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IAction;
import noppes.npcs.api.handler.data.IActionChain;
import noppes.npcs.api.handler.data.actions.IConditionalAction;

import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * Manages a queue of {@link IAction} instances, allowing scheduling of delayed,
 * repeating, or conditional "tasks" for NPC scripting.
 */
public interface IActionManager {

    /**
     * Create a new action instance without immediately scheduling it.
     *
     * @param name            a unique name for this action
     * @param maxDuration     the maximum lifetime of the action in ticks
     * @param delay number of ticks to wait before the first run
     * @param action          code to execute each time the action "fires"
     * @return a fresh {@link IAction} object
     */
    IAction create(String name, int maxDuration, int delay, Consumer<IAction> action);

    IAction create(int maxDuration, int delay, Consumer<IAction> task);

    IAction create(String name, int delay, Consumer<IAction> t);

    IAction create(int delay, Consumer<IAction> t);

    IAction create(String name, Consumer<IAction> t);

    IAction create(String name);

    IAction create(Consumer<IAction> t);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param condition checked every tick, if it returns true, task is fired
     * @param task      code to run once condition first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(Function<IAction, Boolean> condition, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name      unique name
     * @param condition checked every tick, if it returns true, task is fired
     * @param task      code to run once condition first becomes true
     * @return the action scheduled
     */
    IConditionalAction create(String name, Function<IAction, Boolean> condition, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @return the action scheduled
     */
    IConditionalAction create(Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name          unique name
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @return the action scheduled
     */
    IConditionalAction create(String name, Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @param onTermination code to run when the termination condition returns true
     * @return the action scheduled
     */
    IConditionalAction create(Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen, Consumer<IAction> onTermination);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name          unique name
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @param onTermination code to run when the termination condition returns true
     * @return the action scheduled
     */
    IConditionalAction create(String name, Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen, Consumer<IAction> onTermination);

    /**
     * Begin processing scheduled actions.  Must be called once.
     */
    IActionManager start();

    /**
     * Halt processing of actions.  Queued actions remain but will not run until
     * {@link #start()} is called again.
     */
    IActionManager stop();

    /**
     * Multiple actions chained one after another
     * i.e schedule(act1,act2,act3,...)
     *
     * @param actions
     */
    void schedule(IAction... actions);

    /**
     * Schedule an existing action for execution.
     *
     * @param action the action to enqueue
     * @return the action scheduled
     */
    IAction schedule(IAction action);

    /**
     * Multiple tasks chained one after another
     * i.e schedule(task1,task2,task3,...)
     *
     * @param tasks
     */
    void schedule(Consumer<IAction>... tasks);

    /**
     * Convenience for {@link #create(Consumer)} + enqueue.
     *
     * @param task            code to execute each time the task "fires"
     * @return the task scheduled
     */
    IAction schedule(Consumer<IAction> task);

    /**
     * Convenience for {@link #create(String, Consumer)} + enqueue.
     *
     * @param delay  number of ticks to wait before the first task run
     * @param task            code to execute each time the task "fires"
     * @return the task scheduled
     */
    IAction schedule(int delay, Consumer<IAction> task);

    /**
     * Convenience for {@link #create(String, Consumer)} + enqueue.
     *
     * @param name            a unique name for this action
     * @param task            code to execute each time the task "fires"
     * @return the task scheduled
     */
    IAction schedule(String name, Consumer<IAction> task);

    /**
     * Convenience for {@link #create(String, int, Consumer)} + enqueue.
     *
     * @param name            a unique name for this action
     * @param delay number of ticks to wait before the first task run
     * @param task            code to execute each time the task "fires"
     * @return the task scheduled
     */
    IAction schedule(String name, int delay, Consumer<IAction> task);

    /**
     * Convenience for {@link #create(String, int, int, Consumer)} + enqueue.
     *
     * @param name            a unique name for this action
     * @param maxDuration     the maximum lifetime of the action in ticks
     * @param delay number of ticks to wait before the first task run
     * @param task            code to execute each time the task "fires"
     * @return the task scheduled
     */
    IAction schedule(String name, int maxDuration, int delay, Consumer<IAction> task);

    IAction schedule(int maxDuration, int delay, Consumer<IAction> task);

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
     * @param name
     * @return fetches queued up IAction with given name from actionQueue, parallelActions and conditionalActions
     */
    IAction getAction(String name);

    /**
     * Retrieve the entire action queue.
     *
     * @return live reference to the internal {@link Queue} of actions
     */
    Queue<IAction> getActionQueue();

    ///////////////////////////////////////////////////
    ///////////////////////////////////////////////////
    // Conditionals

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param condition checked every tick, if it returns true, task is fired
     * @param task      code to run once condition first becomes true
     * @return the action scheduled
     */
    IConditionalAction schedule(Function<IAction, Boolean> condition, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @return the action scheduled
     */
    IConditionalAction schedule(Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @param onTermination code to run when the termination condition returns true
     * @return the action scheduled
     */
    IConditionalAction schedule(Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen, Consumer<IAction> onTermination);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name      unique name
     * @param condition checked every tick, if it returns true, task is fired
     * @param task      code to run once condition first becomes true
     * @return the action scheduled
     */
    IConditionalAction schedule(String name, Function<IAction, Boolean> condition, Consumer<IAction> task);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name          unique name
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @return the action scheduled
     */
    IConditionalAction schedule(String name, Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen);

    /**
     * Schedule a conditional action that gives up after at most maxChecks attempts.
     *
     * @param name          unique name
     * @param condition     checked every tick, if it returns true, task is fired
     * @param task          code to run once condition first becomes true
     * @param terminateWhen checked every tick, if it returns true, action is terminated (gets marked done)
     * @param onTermination code to run when the termination condition returns true
     * @return the action scheduled
     */
    IConditionalAction schedule(String name, Function<IAction, Boolean> condition, Consumer<IAction> task, Function<IAction, Boolean> terminateWhen, Consumer<IAction> onTermination);

    /**
     * Multiple conditionals
     * i.e schedule(act1,act2,act3,...)
     *
     * @param actions
     */
    void schedule(IConditionalAction... actions);

    IConditionalAction schedule(IConditionalAction action);

    /**
     *
     * @return the list of all conditional actions scheduled
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
     * @param name action name to check for
     * @return true if action is scheduled in actionQueue {@link #getActionQueue()}
     */
    boolean hasAction(String name);

    /**
     * @param name action name to check for
     * @return true if action is scheduled in any of the 3 action, parallel and conditional action queues
     */
    boolean hasAny(String name);

    /**
     * Remove every scheduled action immediately.
     */
    void clear();

    /**
     * @param name action name to check for
     * @return true if action is scheduled in conditionalActions {@link #getConditionalActions()}
     */
    boolean hasConditional(String name);

    /**
     * Multiple actions in parallel
     * i.e scheduleParallel(act1,act2,act3,...)
     *
     * @param actions
     */
    void scheduleParallel(IAction... actions);

    /**
     * Schedules actions on the parallelQueue, where all actions are executed simultaneously
     *
     * @param action
     * @return
     */

    IAction scheduleParallel(IAction action);

    void scheduleParallel(Consumer<IAction>... tasks);

    IAction scheduleParallel(Consumer<IAction> task);

    IAction scheduleParallel(int delay, Consumer<IAction> task);

    IAction scheduleParallel(int maxDuration, int delay, Consumer<IAction> task);

    IAction scheduleParallel(String name, Consumer<IAction> task);

    IAction scheduleParallel(String name, int delay, Consumer<IAction> task);

    IAction scheduleParallel(String name, int maxDuration, int delay, Consumer<IAction> task);

    IActionChain chain();

    IActionChain parallelChain();

    /**
     * @return the list of all parallel actions scheduled
     */
    Queue<IAction> getParallelActions();

    /**
     * @param name action name to check for
     * @return true if action is scheduled in parallelActionQueue {@link #getParallelActions()}
     */
    boolean hasParallel(String name);
}
