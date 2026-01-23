package noppes.npcs.api.handler.data;

import java.util.function.Consumer;

public interface IActionChain {

    String getName();

    /**
     * @param name of chain
     * @return
     */
    IActionChain setName(String name);

    /**
     *
     * @return queue this chain is scheduled on
     */
    IActionQueue getQueue();

    /**
     *
     * @param delay ticks between an IAction and another
     * @param name  name of IAction
     * @param task  task of IAction
     * @return
     */
    IActionChain after(int delay, String name, Consumer<IAction> task);

    IActionChain after(int delay, Consumer<IAction> task);

    /**
     * Start IActionManager
     *
     * @return
     */
    IActionChain start();
}
