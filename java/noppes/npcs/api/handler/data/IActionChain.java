package noppes.npcs.api.handler.data;

import java.util.function.Consumer;

public interface IActionChain {

    String getName();

    IActionChain setName(String name);

    IActionQueue getQueue();

    IActionChain after(int delay, String name, Consumer<IAction> task);

    IActionChain after(int delay, Consumer<IAction> task);

    /**
     * Start IActionManager
     * @return
     */
    IActionChain start();
}
