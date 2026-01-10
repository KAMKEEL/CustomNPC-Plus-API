package noppes.npcs.api.event;

import noppes.npcs.api.IBlock;
import noppes.npcs.api.entity.IEntity;
import noppes.npcs.api.entity.IProjectile;

public interface IProjectileEvent extends ICustomNPCsEvent {

    public IProjectile getProjectile();
    public IEntity getSource();

    /**
     * @hookName projectileTick
     */
    interface UpdateEvent extends IProjectileEvent {
    }

    /**
     * @hookName projectileImpact
     */
    interface ImpactEvent extends IProjectileEvent {
        public int getType();
        public IEntity getEntity();
        public IBlock getBlock();
    }

}
