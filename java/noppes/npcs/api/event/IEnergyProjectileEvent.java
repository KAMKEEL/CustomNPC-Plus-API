package noppes.npcs.api.event;

import noppes.npcs.api.IBlock;
import noppes.npcs.api.entity.IEnergyProjectile;
import noppes.npcs.api.entity.IEntity;

public interface IEnergyProjectileEvent extends ICustomNPCsEvent {

    IEnergyProjectile getProjectile();

    IEntity getOwner();

    /**
     * @hookName energyProjectileFired
     */
    interface FiredEvent extends IEnergyProjectileEvent {
    }

    /**
     * @hookName energyProjectileTick
     */
    interface UpdateEvent extends IEnergyProjectileEvent {
    }

    /**
     * @hookName energyProjectileEntityImpact
     */
    interface EntityImpactEvent extends IEnergyProjectileEvent {
        IEntity getTarget();

        float getDamage();

        void setDamage(float damage);
    }

    /**
     * @hookName energyProjectileBlockImpact
     */
    interface BlockImpactEvent extends IEnergyProjectileEvent {
        IBlock getBlock();
    }

    /**
     * @hookName energyProjectileExpired
     */
    interface ExpiredEvent extends IEnergyProjectileEvent {
    }
}
