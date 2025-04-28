package noppes.npcs.api.handler.data.actions;

import noppes.npcs.api.handler.data.IAction;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IConditionalAction extends IAction {

    /**
     * @param predicate supplier checked every tick, if it returns true, task is fired
     * @return
     */
    IConditionalAction setPredicate(Supplier<Boolean> predicate);

    /**
     * @param terminateWhen supplier checked every tick, if it returns true, action is terminated (gets marked done)
     * @return this action
     */
    IConditionalAction setTerminationPredicate(Supplier<Boolean> terminateWhen);

    /**
     * @param onTermination code to run when the termination predicate returns true
     * @return this action
     */
    IConditionalAction setTerminationTask(Consumer<IAction> onTermination);

    /**
     * @return true if predicate was satisfied and task ran  (i.e can be called in termination task to see if original task was executed
     * then do code based on that, if not return early)
     */
    boolean wasTaskExecuted();

    /**
     * @param maxChecks maximum times to test predicate before auto‐cancelling
     * @return this action
     */
    IConditionalAction setMaxChecks(int maxChecks);

    IConditionalAction after(IConditionalAction after);

    IConditionalAction after(Supplier<Boolean> predicate, Consumer<IAction> task);

    IConditionalAction after(String name, Supplier<Boolean> predicate, Consumer<IAction> task);

    IConditionalAction after(Supplier<Boolean> predicate, Supplier<Boolean> terminate, Consumer<IAction> task);

    IConditionalAction after(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminate, Consumer<IAction> task);

    IConditionalAction after(Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> onTermination, Consumer<IAction> task);

    IConditionalAction after(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminateWhen, Consumer<IAction> onTermination, Consumer<IAction> task);
}
