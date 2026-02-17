package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy dome barrier - a spherical shield centered on the caster.
 */
public interface IEnergyDome<T extends Entity> extends IEnergyBarrier<T> {

    float getDomeRadius();

    void setDomeRadius(float radius);
}
