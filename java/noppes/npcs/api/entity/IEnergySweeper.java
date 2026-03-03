package noppes.npcs.api.entity;

import net.minecraft.entity.Entity;

/**
 * Entity-level interface for sweeper beam entities.
 * Created via IEnergyController.createSweeper().
 * Configure properties, then call spawn() to place in the world.
 */
public interface IEnergySweeper<T extends Entity> extends IEnergyAbility<T> {

    // ==================== BEAM DIMENSIONS ====================

    float getBeamLength();
    void setBeamLength(float length);

    float getBeamWidth();
    void setBeamWidth(float width);

    float getBeamHeight();
    void setBeamHeight(float height);

    // ==================== ROTATION ====================

    float getSweepSpeed();
    void setSweepSpeed(float degreesPerTick);

    int getNumberOfRotations();
    void setNumberOfRotations(int rotations);

    boolean isLockOnTarget();
    void setLockOnTarget(boolean lock);

    // ==================== DAMAGE ====================

    float getDamage();
    void setDamage(float damage);

    int getDamageInterval();
    void setDamageInterval(int ticks);

    boolean isPiercing();
    void setPiercing(boolean piercing);

    // ==================== SPAWNING ====================

    /** Spawn this sweeper entity into the world. */
    void spawn();
}
