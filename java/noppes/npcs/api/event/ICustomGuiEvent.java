package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.gui.ICustomGui;
import noppes.npcs.api.item.IItemStack;

public interface ICustomGuiEvent extends IPlayerEvent {

    ICustomGui getGui();

    int getId();

    /**
     * @hookName customGuiButton
     */
    interface ButtonEvent extends ICustomGuiEvent {
    }

    /**
     * @hookName customGuiTextfield
     */
    interface UnfocusedEvent extends ICustomGuiEvent {
    }

    /**
     * @hookName customGuiClosed
     */
    interface CloseEvent extends ICustomGuiEvent {
    }

    /**
     * @hookName customGuiScroll
     */
    interface ScrollEvent extends ICustomGuiEvent {
        String[] getSelection();

        boolean doubleClick();

        int getScrollIndex();
    }

    /**
     * @hookName customGuiSlot
     */
    interface SlotEvent extends ICustomGuiEvent {
        IItemStack getStack();
    }

    /**
     * @hookName customGuiSlotClicked
     */
    @Cancelable
    interface SlotClickEvent extends ICustomGuiEvent {
        IItemStack getStack();

        int getDragType();
    }
}
