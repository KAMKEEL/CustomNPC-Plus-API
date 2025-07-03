package noppes.npcs.api.handler.data;

import noppes.npcs.api.handler.IActionManager;
import noppes.npcs.controllers.data.action.ActionManager;

import java.util.Queue;
import java.util.function.Consumer;

public interface IActionQueue {
    IActionQueue start();

    IActionQueue stop();

    IActionManager getManager();

    String getName();

    boolean isParallel();

    Queue<IAction> getQueue();

    IActionQueue setParallel(boolean parallel);

    /**
     * @return True to auto-remove this queue from the IActionManager when no IActions are scheduled or queue is empty
     * Default: true
     */
    boolean isKilledWhenEmpty();

    /**
     * @return ticks it takes to remove this queue from IActionManager after {{@link #isKilledWhenEmpty()}} is satisfied
     * If an IAction is scheduled after it's satisfied, the kill process is aborted.
     * Default: 100 ticks
     */
    int getKillAfterTicks();

    IActionQueue killWhenEmpty(boolean killWhenEmpty);

    /**
     * @param ticks to kill queue after when queue has no active tasks
     *              If an IAction is scheduled during the kill process, process is aborted
     * @return
     */
    IActionQueue killAfter(int ticks);

    boolean isKilled();

    /**
     * @return kills queue and removes it from IActionManager immediately
     */
    IActionQueue kill();

    IAction schedule(IAction action);

    void schedule(IAction... actions);

    void schedule(Consumer<IAction>... tasks);

    IAction schedule(Consumer<IAction> task);

    IAction schedule(int delay, Consumer<IAction> task);

    IAction schedule(int maxDuration, int delay, Consumer<IAction> task);

    IAction schedule(String name, Consumer<IAction> task);

    IAction schedule(String name, int delay, Consumer<IAction> task);

    IAction schedule(String name, int maxDuration, int delay, Consumer<IAction> task);

    IAction scheduleActionAt(int index, IAction action);

    int getIndex(IAction action);

    IAction getCurrentAction();

    boolean has(IAction action);

    boolean has(String actionName);

    IAction get(String actionName);

    boolean cancel(IAction action);

    boolean cancel(String actionName);

    void clear();

    /**
     * @return an IActionChain based on this queue.
     */

    IActionChain chain();
}
