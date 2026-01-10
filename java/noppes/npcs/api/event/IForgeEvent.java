package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Event;
import noppes.npcs.api.IWorld;
import noppes.npcs.api.entity.IEntity;

public interface IForgeEvent extends ICustomNPCsEvent {

    Event getEvent();

    /**
     * @hookName forgeWorld
     */
    interface WorldEvent extends IForgeEvent {
        IWorld getWorld();
    }

    /**
     * @hookName forgeEntity
     */
    interface EntityEvent extends IForgeEvent {
        IEntity getEntity();
    }

    /**
     * @hookName forgeInit
     */
    interface InitEvent extends IForgeEvent {
    }
}
