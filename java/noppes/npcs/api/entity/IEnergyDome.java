package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy dome barrier - a spherical shield centered on the caster.
 */
public interface IEnergyDome<T extends Entity> extends IEnergyBarrier<T> {

    /** @return The radius of the dome in blocks. */
    float getDomeRadius();

    /** @param radius The radius of the dome in blocks. */
    void setDomeRadius(float radius);
}
