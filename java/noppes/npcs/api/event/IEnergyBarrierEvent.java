package noppes.npcs.api.event;

import noppes.npcs.api.entity.IEnergyBarrier;
import noppes.npcs.api.entity.IEnergyProjectile;
import noppes.npcs.api.entity.IEntity;

public interface IEnergyBarrierEvent extends ICustomNPCsEvent {

    IEnergyBarrier getBarrier();

    IEntity getOwner();

    /**
     * @hookName energyBarrierSpawned
     */
    interface SpawnedEvent extends IEnergyBarrierEvent {
    }

    /**
     * @hookName energyBarrierTick
     */
    interface UpdateEvent extends IEnergyBarrierEvent {
    }

    /**
     * @hookName energyBarrierHit
     */
    interface HitEvent extends IEnergyBarrierEvent {
        IEnergyProjectile getProjectile();

        float getDamage();

        void setDamage(float damage);
    }

    /**
     * @hookName energyBarrierDestroyed
     */
    interface DestroyedEvent extends IEnergyBarrierEvent {
    }
}
