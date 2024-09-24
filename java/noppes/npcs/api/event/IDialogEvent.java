package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.handler.data.IDialog;

public interface IDialogEvent extends IPlayerEvent {

    IDialog getDialog();

    @Cancelable
    interface DialogOpen extends IDialogEvent {
    }

    @Cancelable
    interface DialogOption extends IDialogEvent {
    }

    interface DialogClosed extends IDialogEvent {
    }
}
