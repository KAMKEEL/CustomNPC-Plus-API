package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy slicer projectile - a thin, wide blade that slices through targets.
 */
public interface IEnergySlicer<T extends Entity> extends IEnergyProjectile<T> {

    float getSliceWidth();

    void setSliceWidth(float width);

    float getSliceThickness();

    void setSliceThickness(float thickness);

    boolean isPiercing();

    void setPiercing(boolean piercing);
}
