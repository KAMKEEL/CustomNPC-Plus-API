package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy disc projectile - a flat spinning disc with optional boomerang behavior.
 */
public interface IEnergyDisc<T extends Entity> extends IEnergyProjectile<T> {

    float getDiscRadius();

    void setDiscRadius(float radius);

    float getDiscThickness();

    void setDiscThickness(float thickness);

    boolean isVertical();

    void setVertical(boolean vertical);

    boolean isBoomerang();

    void setBoomerang(boolean boomerang);

    int getBoomerangDelay();

    void setBoomerangDelay(int ticks);

    boolean isReturning();
}
