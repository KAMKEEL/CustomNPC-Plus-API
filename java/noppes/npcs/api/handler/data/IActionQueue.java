package noppes.npcs.api.handler.data;

import noppes.npcs.controllers.data.action.ActionManager;

import java.util.Queue;
import java.util.function.Consumer;

public interface IActionQueue {
    IActionQueue start();

    IActionQueue stop();

    ActionManager getManager();

    String getName();

    boolean isParallel();

    Queue<IAction> getQueue();

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
