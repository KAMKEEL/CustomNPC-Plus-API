package noppes.npcs.api.event;

import noppes.npcs.api.IBlock;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IProjectile;

public interface IProjectileEvent extends ICustomNPCsEvent {

    IProjectile getProjectile();

    IEntity getSource();

    interface UpdateEvent extends IProjectileEvent {
    }

    interface ImpactEvent extends IProjectileEvent {
        int getType();

        IEntity getEntity();

        IBlock getBlock();
    }

}
