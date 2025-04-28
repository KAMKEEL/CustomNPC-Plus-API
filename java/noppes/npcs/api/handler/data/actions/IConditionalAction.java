package noppes.npcs.api.handler.data.actions;

import noppes.npcs.api.handler.data.IAction;

public interface IConditionalAction extends IAction {

    IConditionalAction setMaxChecks(int maxChecks);
}
