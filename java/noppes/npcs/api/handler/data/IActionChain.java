package noppes.npcs.api.handler.data;

import java.util.function.Consumer;

public interface IActionChain {

    IActionChain after(int delay, Consumer<IAction> task);
}
