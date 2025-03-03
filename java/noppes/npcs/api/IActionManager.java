package noppes.npcs.api;

import java.util.Queue;
import java.util.function.Consumer;

public interface IActionManager {
    /**
     * @param name
     * @param maxDuration     once maxDuration is reached the action ends
     * @param action          function to invoke as long as this action is active
     * @param startAfterTicks number of ticks to elapse before starting action
     * @return
     */
    IAction createAction(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Starts ActionManager (paused by default)
     */
    void start();

    /**
     * stops ActionManager
     */
    void stop();

    void addScheduledAction(IAction action);

    void addScheduledAction(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * @param index  to add action at in the actionQueue
     * @param action
     */
    void addScheduledActionAt(int index, IAction action);

    /**
     * @param after      The action to add toSchedule after
     * @param toSchedule
     */
    void scheduleActionAfter(IAction after, IAction toSchedule);

    /**
     * @param action
     * @return action's index in the actionQueue
     */
    int getActionIndex(IAction action);

    IAction getCurrentAction();

    Queue<IAction> getActionQueue();
}
