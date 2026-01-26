package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.handler.data.IDialog;

public interface IDialogEvent extends IPlayerEvent {

    IDialog getDialog();

    int getDialogId();

    int getOptionId();

    @Cancelable
    interface DialogOpen extends IDialogEvent {
    }

    @Cancelable
    interface DialogOption extends IDialogEvent {
    }

    /**
     * @hookName dialogClose
     */
    interface DialogClosed extends IDialogEvent {
    }
}
