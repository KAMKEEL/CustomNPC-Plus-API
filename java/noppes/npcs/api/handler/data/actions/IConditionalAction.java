package noppes.npcs.api.handler.data.actions;

import noppes.npcs.api.handler.data.IAction;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IConditionalAction extends IAction {

    /**
     * @param condition supplier checked every tick, if it returns true, task is fired
     * @return
     */
    IConditionalAction setCondition(Supplier<Boolean> condition);

    /**
     * @param terminateWhen supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @return this action
     */
    IConditionalAction terminateWhen(Supplier<Boolean> terminateWhen);

    /**
     * @param onTermination code to run when the termination condition returns true
     * @return this action
     */
    IConditionalAction onTermination(Consumer<IAction> onTermination);

    /**
     * @return true if condition was satisfied and task ran  (i.e can be called in termination task to see if original task was executed
     * then do code based on that, if not return early)
     */
    boolean wasTaskExecuted();

    /**
     * Note: Only for Conditional Actions
     * @return how many times this conditional action has tested its condition
     */
    int getCheckCount();

    /**
     * Note: Only for Conditional Actions
     * @return the maximum number of checks before auto-expiring, or -1 if unlimited
     */
    int getMaxChecks();


    /**
     * @param maxChecks maximum times to test condition before auto-cancelling
     * @return this action
     */
    IConditionalAction setMaxChecks(int maxChecks);

    IConditionalAction after(IConditionalAction after);

    IConditionalAction after(Supplier<Boolean> condition, Consumer<IAction> task);

    IConditionalAction after(String name, Supplier<Boolean> condition, Consumer<IAction> task);

    IConditionalAction after(Supplier<Boolean> condition, Consumer<IAction> task, Supplier<Boolean> terminate);

    IConditionalAction after(String name, Supplier<Boolean> condition, Consumer<IAction> task, Supplier<Boolean> terminate);

    IConditionalAction after(Supplier<Boolean> condition, Consumer<IAction> task, Supplier<Boolean> terminateWhen, Consumer<IAction> onTermination);

    IConditionalAction after(String name, Supplier<Boolean> condition, Consumer<IAction> task, Supplier<Boolean> terminateWhen, Consumer<IAction> onTermination);
}
