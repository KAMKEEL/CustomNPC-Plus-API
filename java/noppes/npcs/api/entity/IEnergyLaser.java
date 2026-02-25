package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Represents an energy laser entity - a sweeping beam that follows the caster's look vector.
 */
public interface IEnergyLaser<T extends Entity> extends IEnergyProjectile<T> {

    float getLaserWidth();

    void setLaserWidth(float width);

    float getExpansionSpeed();

    void setExpansionSpeed(float speed);

    float getMaxLength();

    void setMaxLength(float maxLength);

    float getCurrentLength();

    boolean isFullyExtended();

    double getDirX();

    double getDirY();

    double getDirZ();

    void setDirection(double x, double y, double z);

    double getEndX();

    double getEndY();

    double getEndZ();
}
