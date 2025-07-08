package noppes.npcs.api.handler.data;

import noppes.npcs.controllers.data.action.ActionListener;

public interface IActionListener {
    ActionListener.Hook getOrCreateHook(String name);

    ActionListener.Hook getHook(String hookName);

    boolean fire(String name);
}
