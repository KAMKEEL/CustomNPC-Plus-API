package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy laser projectile - a fast expanding line.
 */
public interface IEnergyLaser<T extends Entity> extends IEnergyProjectile<T> {

    float getLaserWidth();

    void setLaserWidth(float width);

    float getExpansionSpeed();

    void setExpansionSpeed(float speed);

    int getLingerTicks();

    void setLingerTicks(int ticks);

    float getCurrentLength();

    boolean isFullyExtended();

    double getDirX();

    double getDirY();

    double getDirZ();

    void setDirection(double x, double y, double z);

    double getEndX();

    double getEndY();

    double getEndZ();

    float getLingerAlpha();

    boolean isLockVerticalDirection();

    void setLockVerticalDirection(boolean lock);
}
