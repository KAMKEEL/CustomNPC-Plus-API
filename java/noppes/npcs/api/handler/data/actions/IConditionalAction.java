package noppes.npcs.api.handler.data.actions;

import noppes.npcs.api.handler.data.IAction;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface IConditionalAction extends IAction {

    /**
     *
     * @param maxChecks maximum times to test predicate before auto‐cancelling
     * @return this action
     */
    IConditionalAction setMaxChecks(int maxChecks);

    IConditionalAction after(IConditionalAction after);

    IConditionalAction after(Supplier<Boolean> predicate, Consumer<IAction> task);

    IConditionalAction after(String name, Supplier<Boolean> predicate, Consumer<IAction> task);

    IConditionalAction after(Supplier<Boolean> predicate, Supplier<Boolean> terminate, Consumer<IAction> task);

    IConditionalAction after(String name, Supplier<Boolean> predicate, Supplier<Boolean> terminate, Consumer<IAction> task);
}
