package noppes.npcs.api.handler.data;

import java.util.function.Consumer;

/**
 * Represents an action that can be executed over a period of time.
 * Provides methods to query its state, update data, and chain scheduling.
 */
public interface IAction {
    /**
     * Gets the number of times this action has been executed.
     *
     * @return the execution count.
     */
    int getCount();

    /**
     * Gets the elapsed duration (in ticks) since the action began.
     *
     * @return the duration in ticks.
     */
    int getDuration();

    /**
     * Gets the name of this action.
     *
     * @return the action name.
     */
    String getName();

    /**
     * Gets the maximum duration (in ticks) that this action is allowed to run.
     *
     * @return the maximum duration in ticks.
     */
    int getMaxDuration();

    /**
     * Marks the action as completed or not.
     *
     * @param done true to mark the action as done, false otherwise.
     */
    void setDone(boolean done);

    /**
     * Checks if the action has been marked as completed.
     *
     * @return true if the action is done, false otherwise.
     */
    boolean isDone();

    /**
     * Retrieves the data associated with the specified key.
     *
     * @param key the key of the data.
     * @return the associated data, or null if not present.
     */
    Object getData(String key);

    /**
     * Stores data with the specified key.
     *
     * @param key   the key under which the data is stored.
     * @param value the data to store.
     */
    void addData(String key, Object value);

    /**
     * Gets the interval (in ticks) between each update of this action.
     *
     * @return the number of ticks between updates.
     */
    int getUpdateEveryXTick();

    /**
     * Sets the update frequency in ticks.
     *
     * @param X the number of ticks between each update.
     */
    void setUpdateEveryXTick(int X);

    /**
     * Gets the number of ticks to wait before starting the action.
     *
     * @return the delay in ticks before the action starts.
     */
    int getStartAfterTicks();

    /**
     * Creates a new IAction instance with the given parameters.
     *
     * @param name            the name of the action.
     * @param maxDuration     the maximum duration (in ticks) the action can run.
     * @param startAfterTicks the delay in ticks before the action starts.
     * @param action          the consumer defining the action's behavior.
     * @return a new IAction instance.
     */
    IAction create(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Schedules another action to be executed immediately after this action.
     *
     * @param action the action to schedule after this one.
     */
    void scheduleAfter(IAction action);
}
