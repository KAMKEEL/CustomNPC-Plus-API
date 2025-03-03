package noppes.npcs.api;

import java.util.function.Consumer;

public interface IAction {

    /**
     * @return number of times the function passed has been called upon
     */
    int getCount();

    /**
     * @return number of ticks since action starting
     */
    int getDuration();

    String getName();

    int getMaxDuration();

    /**
     * @param done set to true to end action
     */
    void setDone(boolean done);

    boolean isDone();

    /**
     * Allows the storage of objects that might be needed within the action.
     * Equivalent to npc.getTempData().
     * All data deleted on action ending
     *
     * @param key
     * @return
     */
    void addData(String key, Object value);

    Object getData(String key);

    int getUpdateEveryXTick();

    /**
     * @param X calls upon the function passed every X ticks
     */
    void setUpdateEveryXTick(int X);

    /**
     * @return number of ticks to elapse before starting action
     */
    int getStartAfterTicks();

    /**
     * Creates a new IAction. allows for instant daisy-chaining without having to go through npc.getActionManager() again
     *
     * @param name
     * @param maxDuration
     * @param startAfterTicks
     * @param action
     * @return
     */
    IAction create(String name, int maxDuration, int startAfterTicks, Consumer<IAction> action);

    /**
     * Schedules newAction right after this one, skipping the line of everything after
     *
     * @param newAction
     */
    void scheduleAfter(IAction newAction);
}
