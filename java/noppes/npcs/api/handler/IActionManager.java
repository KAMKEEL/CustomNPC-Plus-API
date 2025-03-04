package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IAction;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * Interface for managing and scheduling actions.
 * Provides methods to create, start, stop, and queue actions.
 */
public interface IActionManager {
    /**
     * Creates a new IAction instance with the specified parameters.
     *
     * @param name            the name of the action.
     * @param maxDuration     the maximum duration (in ticks) for the action.
     * @param startAfterTicks the delay in ticks before the action starts.
     * @param action          the consumer defining the action's behavior.
     * @return a new IAction instance.
     */
    IAction createAction(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Starts the action manager, enabling the processing of scheduled actions.
     */
    void start();

    /**
     * Stops the action manager, halting the processing of scheduled actions.
     */
    void stop();

    /**
     * Schedules an action by adding it to the action queue.
     *
     * @param action the action to be scheduled.
     */
    void addScheduledAction(IAction action);

    /**
     * Creates and schedules an action with the given parameters.
     *
     * @param name            the name of the action.
     * @param maxDuration     the maximum duration (in ticks) for the action.
     * @param startAfterTicks the delay in ticks before the action starts.
     * @param action          the consumer defining the action's behavior.
     */
    void addScheduledAction(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Inserts an action into the action queue at the specified index.
     *
     * @param index  the position in the queue where the action should be added.
     * @param action the action to insert.
     */
    void addScheduledActionAt(int index, IAction action);

    /**
     * Schedules an action to be executed immediately after the specified action.
     *
     * @param after      the action after which the new action should run.
     * @param toSchedule the action to schedule.
     */
    void scheduleActionAfter(IAction after, IAction toSchedule);

    /**
     * Retrieves the index of the specified action in the action queue.
     *
     * @param action the action whose index is to be determined.
     * @return the index of the action in the queue, or -1 if not found.
     */
    int getActionIndex(IAction action);

    /**
     * Gets the current action (the one at the head of the queue).
     *
     * @return the current action, or null if the queue is empty.
     */
    IAction getCurrentAction();

    /**
     * Returns the queue of scheduled actions.
     *
     * @return the action queue.
     */
    Queue<IAction> getActionQueue();
}
