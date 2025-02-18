package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IPlayer;
import noppes.npcs.api.item.IItemCustomizable;
import noppes.npcs.api.item.IItemStack;

public interface IItemEvent extends ICustomNPCsEvent {

    IItemCustomizable getItem();

    interface InitEvent extends IItemEvent {
    }

    interface UpdateEvent extends IItemEvent {
        IEntity getEntity();
    }

    @Cancelable
    interface TossedEvent extends IItemEvent {
        IEntity getEntity();

        IPlayer getPlayer();
    }

    interface PickedUpEvent extends IItemEvent {
        IPlayer getPlayer();
    }

    @Cancelable
    interface SpawnEvent extends IItemEvent {
        IEntity getEntity();
    }

    @Cancelable
    interface InteractEvent extends IItemEvent {
        int getType();

        IEntity getTarget();

        IPlayer getPlayer();
    }

    @Cancelable
    interface RightClickEvent extends IItemEvent {
        int getType();

        Object getTarget();

        IPlayer getPlayer();
    }

    @Cancelable
    interface AttackEvent extends IItemEvent {
        int getType();

        IEntity getTarget();

        IEntity getSwingingEntity();
    }

    interface StartUsingItem extends IItemEvent {
        IPlayer getPlayer();

        int getDuration();
    }

    interface UsingItem extends IItemEvent {
        IPlayer getPlayer();

        int getDuration();
    }

    interface StopUsingItem extends IItemEvent {
        IPlayer getPlayer();

        int getDuration();
    }

    interface FinishUsingItem extends IItemEvent {
        IPlayer getPlayer();

        int getDuration();
    }

    // onBreakEvent if Durability Expires or Consumed
    interface BreakItem extends IItemEvent {

        IItemStack getBrokenStack();

        IPlayer getPlayer();
    }

    // onRepairEvent
    interface RepairItem extends IItemEvent {

        IItemStack getLeft();

        IItemStack getRight();

        IItemStack getOutput();

        float getAnvilBreakChance();
    }
}
