package noppes.npcs.api.handler.data;

import java.util.function.Consumer;

public interface IActionChain {

    IActionChain after(int delay, String name, Consumer<IAction> task);

    IActionChain after(int delay, Consumer<IAction> task);

    /**
     * Start IActionManager
     * @return
     */
    IActionChain start();
}
