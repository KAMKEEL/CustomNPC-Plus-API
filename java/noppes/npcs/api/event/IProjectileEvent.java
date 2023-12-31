package noppes.npcs.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import noppes.npcs.api.IBlock;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IProjectile;
import noppes.npcs.api.handler.data.IQuest;
import noppes.npcs.api.item.IItemStack;

public interface IProjectileEvent extends ICustomNPCsEvent {

    public IProjectile getProjectile();
    public IEntity getSource();

    interface UpdateEvent extends IProjectileEvent {
    }

    interface ImpactEvent extends IProjectileEvent {
        public int getType();
        public IEntity getEntity();
        public IBlock getBlock();
    }

}
